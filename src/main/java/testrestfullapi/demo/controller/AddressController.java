package testrestfullapi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import testrestfullapi.demo.entity.User;
import testrestfullapi.demo.model.AddressRequest;
import testrestfullapi.demo.model.AddressResponse;
import testrestfullapi.demo.model.WebResponse;
import testrestfullapi.demo.service.AddressService;

@RestController
public class AddressController
{
    @Autowired
    private AddressService addressService;

    @PostMapping(
            path = "/api/contacts/{contactId}/addreesses",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse>create(User user,
                                              @RequestBody AddressRequest request,
                                              @PathVariable("contactId") String contactId){
        request.setContactId(contactId);
        AddressResponse addressResponse = addressService.create(user, request);
        return WebResponse.<AddressResponse>builder().data(addressResponse).build();
    }

}
