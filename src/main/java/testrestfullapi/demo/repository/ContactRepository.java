package testrestfullapi.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import testrestfullapi.demo.entity.Contact;
import testrestfullapi.demo.entity.User;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact , String>, JpaSpecificationExecutor<Contact> {
    Optional<Contact> findFirstByUserAndId(User user, String id);



}
