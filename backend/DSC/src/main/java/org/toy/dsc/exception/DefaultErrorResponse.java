package org.toy.dsc.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.toy.dsc.constant.ResponseMessage;

import java.time.LocalDateTime;

@Setter
@Getter
public class DefaultErrorResponse {
    private int statusCode;
    private String error;
    private String message;
    private LocalDateTime timestamp;

    public DefaultErrorResponse(ResponseMessage responseMessage){
        this.statusCode = responseMessage.getHttpStatus().value();
        this.error = responseMessage.getHttpStatus().name();
        this.message = responseMessage.getMessage();
        this.timestamp = LocalDateTime.now();
    }

    public DefaultErrorResponse(String message) {
        this.message = message;
    }
}
