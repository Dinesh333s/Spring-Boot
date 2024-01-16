package com.floppy.SpringbootRestfulwebservicesdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resource;
    private String field_name;

    private Long fieldValue;

    public ResourceNotFoundException(String resource, String field_name, Long fieldValue)
    {
        super(String.format("%s not found with %s:'%s",resource,field_name,fieldValue));
        this.field_name = field_name;
        this.resource = resource;
        this.fieldValue = fieldValue;
    }

}
