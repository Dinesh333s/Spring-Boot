package com.floppy.SpringbootRestfulwebservicesdemo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

@Schema(description = "UserDto Model Information")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//Dont include Sensitive Info in DTO class
public class Userdto {

    @Schema(description = "User ID")
    private long id;
    @Schema(description = "User Firstname")
    @NotEmpty(message = "firstname should not be null")
    private String firstname;
    @Schema(description = "User Lastname")
    @NotEmpty(message = "lastname should not be null")
    private String lastname;
    @Schema(description = "User Email")
    @NotEmpty(message = "email should not be null or empty")
    @Email
    private String email;
}
