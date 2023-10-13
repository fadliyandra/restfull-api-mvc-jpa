package testrestfullapi.demo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactResponse {

    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;


}
