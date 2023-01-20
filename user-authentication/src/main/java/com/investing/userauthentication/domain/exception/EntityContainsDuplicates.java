package com.investing.userauthentication.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EntityContainsDuplicates extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public EntityContainsDuplicates(String message) {
        super(message);
    }

}
