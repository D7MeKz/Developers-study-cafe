package org.toy.dsc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.toy.dsc.constant.ResponseMessage;
import org.toy.dsc.exception.DefaultErrorResponse;
import org.toy.dsc.exception.exception.DefaultException;
import org.toy.dsc.exception.exception.JPAUnexpectedError;
import org.toy.dsc.exception.exception.UserDoesNotExist;

@ControllerAdvice // 모든 컨트롤러에 발생한 예외에 적용 (전역), 스프링 빈 으로 등록됨.
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DefaultException.class})
    public ResponseEntity<DefaultErrorResponse> handleDefaultException(ResponseMessage responseMessage, String keyword){
        return ResponseEntity.status(responseMessage.getHttpStatus().value())
                .body(new DefaultErrorResponse(responseMessage));
    }

    @ExceptionHandler(value = {UserDoesNotExist.class})
    public ResponseEntity<DefaultErrorResponse> handleUserDoesNotExist(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new DefaultErrorResponse("User does not exist."));
    }

    @ExceptionHandler(value = {JPAUnexpectedError.class})
    public ResponseEntity<DefaultErrorResponse> handleJpaUnexpectedError(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new DefaultErrorResponse("Unexpected Error"));
    }


}
