package com.floppy.SpringbootRestfulwebservicesdemo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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


    private String firstname;

    private String lastname;

    private String email;
}
