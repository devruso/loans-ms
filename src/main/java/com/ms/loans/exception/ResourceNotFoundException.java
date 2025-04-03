package com.ms.loans.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public  ResourceNotFoundException(String resourceName,String fieldName ,String fieldValue){
         super(String.
                 format("Resource with the name %s was not found in %s field, with the value of: %s",
                    resourceName,
                    fieldName,
                    fieldValue));
    }

}
