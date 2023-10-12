package testrestfullapi.demo.model;

import lombok.*;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebResponse<T> {
    private T data;

    private String errors;

    private PagingResponse paging;
}
