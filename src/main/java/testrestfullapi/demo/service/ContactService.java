package testrestfullapi.demo.service;

import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import testrestfullapi.demo.entity.Contact;
import testrestfullapi.demo.entity.User;
import testrestfullapi.demo.model.ContactRequest;
import testrestfullapi.demo.model.ContactResponse;
import testrestfullapi.demo.model.SearchContactRequest;
import testrestfullapi.demo.model.UpdateContactRequset;
import testrestfullapi.demo.repository.ContactRepository;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public ContactResponse create(User user, ContactRequest request){
        validationService.validate(request);

        Contact contact = new Contact();
        contact.setId(UUID.randomUUID().toString());
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setPhone(request.getPhone());
        contact.setUser(user);

        contactRepository.save(contact);
        return toContactResponse(contact);
    }
    private ContactResponse toContactResponse(Contact contact){
        return ContactResponse.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .phone(contact.getPhone())
                .build();
    }
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Page<ContactResponse> search(User user, SearchContactRequest request) {
        Specification<Contact> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get("user"), user));
            if (Objects.nonNull(request.getName())) {
                predicates.add(builder.or(
                        builder.like(root.get("firstName"), "%" + request.getName() + "%"),
                        builder.like(root.get("lastName"), "%" + request.getName() + "%")
                ));
            }
            if (Objects.nonNull(request.getEmail())) {
                predicates.add(builder.like(root.get("email"), "%" + request.getEmail() + "%"));
            }
            if (Objects.nonNull(request.getPhone())) {
                predicates.add(builder.like(root.get("phone"), "%" + request.getPhone() + "%"));
            }

            return query.where(predicates.toArray(new Predicate[]{})).getRestriction();
        };

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        Page<Contact> contacts = contactRepository.findAll(specification, pageable);
        List<ContactResponse> contactResponses = contacts.getContent().stream()
                .map(this::toContactResponse)
                .toList();

        return new PageImpl<>(contactResponses, pageable, contacts.getTotalElements());
    }

  @org.springframework.transaction.annotation.Transactional
    public ContactResponse get(User user, String id){
        Contact contact = contactRepository.findFirstByUserAndId(user, id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conatct not found"));
        return toContactResponse(contact);
  }



@org.springframework.transaction.annotation.Transactional
public ContactResponse update(User user, UpdateContactRequset requset){
        validationService.validate(requset);
        Contact contact = contactRepository.findFirstByUserAndId(user , requset.getId())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));

        contact.setFirstName(requset.getFirstName());
        contact.setLastName(requset.getLastName());
        contact.setEmail(requset.getEmail());
        contact.setPhone(requset.getPhone());
        contactRepository.save(contact);

        return toContactResponse(contact);

}

@org.springframework.transaction.annotation.Transactional
    public void delete(User user, String contactId){
        Contact contact = contactRepository.findFirstByUserAndId(user,contactId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not fund"));
        contactRepository.delete(contact);

}

}
