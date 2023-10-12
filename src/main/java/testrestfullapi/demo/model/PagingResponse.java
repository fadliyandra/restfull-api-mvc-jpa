package testrestfullapi.demo.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagingResponse {
    private Integer currentpage;

    private Integer totalPage;

    private Integer size;
}
