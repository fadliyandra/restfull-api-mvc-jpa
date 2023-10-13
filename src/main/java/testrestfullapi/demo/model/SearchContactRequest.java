package testrestfullapi.demo.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchContactRequest {
    private String name;

    private String email;

   private String phone;

    @NotNull
    private Integer page;

    @NotNull
    private Integer size;

}
