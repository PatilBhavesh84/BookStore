package com.bridgelabz.user.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class LoginDTO {
    @NotEmpty(message = "Please Provide email")
    @Email
    private String email;
    @NotBlank(message = "Please provide password")
    private String password;
}
