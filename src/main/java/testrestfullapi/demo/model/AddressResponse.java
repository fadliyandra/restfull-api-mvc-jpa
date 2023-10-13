package testrestfullapi.demo.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponse {

    private String id;

    private String street;

    private String city;

    private String province;

    private String country;

    private String postalCode;

}
