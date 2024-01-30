package org.toy.dsc.exception.exception;


import lombok.Getter;
import org.toy.dsc.constant.ResponseMessage;

@Getter
public class DefaultException extends RuntimeException{
    private final ResponseMessage responseMessage;
    private final String keyword;

    public DefaultException(ResponseMessage responseMessage, String keyword){
        this.responseMessage = responseMessage;
        this.keyword = keyword;
    }


}
