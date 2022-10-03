package com.bridgelabz.user.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
@Data
public class UserDTO {
    @NotEmpty(message = "First name cant be empty")
    @Pattern(regexp = "[A-Z]{1}[a-z]{2,}", message = "FirstName is Invalid")
    private String firstName;

    @NotEmpty(message = "Last name cant be empty")
    @Pattern(regexp = "[A-Z]{1}[a-z]{2,}", message = "LastName is Invalid")
    private String lastName;

    @NotEmpty(message = "Email cant be empty")
    @Pattern(regexp = "^[\\w+-]+(\\.[\\w-]+)*@[^_\\W]+(\\.[^_\\W]+)?(?=(\\.[^_\\W]{3,}$|\\.[a-zA-Z]{2}$)).*$", message = "Please enter a valid email id")
    private String email;

    @NotEmpty(message = "Address cant be empty")
    private String address;

    @NotBlank(message = "Password cant be blank")
    private String password;
}
