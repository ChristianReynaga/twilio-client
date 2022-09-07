package dev.chrislancer.twilioclient.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {

    private Integer code;
    private String message;
    private String moreInfo;
    private Integer status;

}
