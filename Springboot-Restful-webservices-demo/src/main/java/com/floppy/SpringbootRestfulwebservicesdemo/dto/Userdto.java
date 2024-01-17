package com.floppy.SpringbootRestfulwebservicesdemo.dto;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//Dont include Sensitive Info in DTO class
public class Userdto {


    private long id;
    @NotEmpty(message = "firstname should not be null")
    private String firstname;
    @NotEmpty(message = "lastname should not be null")
    private String lastname;
    @NotEmpty(message = "email should not be null or empty")
    @Email
    private String email;
}
