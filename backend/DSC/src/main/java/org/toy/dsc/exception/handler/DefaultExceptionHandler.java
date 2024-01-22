package org.toy.dsc.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.toy.dsc.constant.ResponseMessage;
import org.toy.dsc.dto.response.DefaultErrorResponse;
import org.toy.dsc.exception.exception.DefaultException;

@ControllerAdvice // 모든 컨트롤러에 발생한 예외에 적용 (전역), 스프링 빈 으로 등록됨.
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DefaultException.class})
    public ResponseEntity<DefaultErrorResponse> handleDefaultException(DefaultException ex){
        return ResponseEntity.status(ex.getResponseMessage().getHttpStatus().value())
                .body(new DefaultErrorResponse(ex.getResponseMessage(),ex.getKeyword()));
    }

}
