package org.toy.dsc.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseMessage {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Invalid request."),
    UNAUTHORIZED_REQUEST(HttpStatus.UNAUTHORIZED, "Unauthorized."),
    FORBIDDEN_ACCESS(HttpStatus.FORBIDDEN, "Forbidden."),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Not found."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "Not allowed method."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Server error."),
    DATA_ACCESS_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Data Access Error"),
    DB_UNEXPECTED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected Error");

    private final HttpStatus httpStatus;
    private final String message;
}
