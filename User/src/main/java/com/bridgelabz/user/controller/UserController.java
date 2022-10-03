package com.bridgelabz.user.controller;

import com.bridgelabz.user.dto.ChangePasswordDTO;
import com.bridgelabz.user.dto.LoginDTO;
import com.bridgelabz.user.dto.ResponseDTO;
import com.bridgelabz.user.dto.UserDTO;
import com.bridgelabz.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/userDetails")
public class UserController {

    @Autowired
    private IUserService userService;

    //Ability to call api to register user
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerUser(@Valid @RequestBody UserDTO userdto) {
        ResponseDTO dto = new ResponseDTO("User Record created successfully !", userService.registerUser(userdto));
        return new ResponseEntity(dto, HttpStatus.CREATED);
    }

    //Ability to call api to login user
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> userLogin(@Valid @RequestBody LoginDTO logindto) {
        ResponseDTO dto = new ResponseDTO("User logged in successfully !", userService.userLogin(logindto));
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    //Ability to call api to change password
    @PutMapping("/changePassword")
    public ResponseEntity<ResponseDTO> changePassword(@Valid @RequestBody ChangePasswordDTO passwordDTO) {
        ResponseDTO dto = new ResponseDTO("Password Resetted successfully !", userService.changePassword(passwordDTO));
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    //Ability to call api to retrieve all user records
    @GetMapping("/retrieveAll")
    public ResponseEntity<ResponseDTO> getAllRecords() {
        ResponseDTO dto = new ResponseDTO("All records retrieved successfully !", userService.getAllRecords());
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    //Ability to call api to retrieve user record by id
    @GetMapping("/retrieve/{id}")
    public ResponseEntity<ResponseDTO> getRecord(@PathVariable Integer id) {
        ResponseDTO dto = new ResponseDTO("Record retrieved successfully !", userService.getRecord(id));
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    //Ability to call api to retrieve user record by token
    @GetMapping("/retrieveByToken/{token}")
    public ResponseEntity<ResponseDTO> getRecordByToken(@PathVariable String token) {
        ResponseDTO dto = new ResponseDTO("Record retrieved successfully !", userService.getRecordByToken(token));
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    //Ability to call api to update user record by id
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateRecord(@PathVariable Integer id, @Valid @RequestBody UserDTO userdto) {
        ResponseDTO dto = new ResponseDTO("Record updated successfully !", userService.updateRecord(id, userdto));
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }

    //Ability to call api to retrieve user record by email
    @GetMapping("/retrieveByEmail/{email}")
    public ResponseEntity<ResponseDTO> getUserByEmailId(@PathVariable String email) {
        ResponseDTO responseDTO = new ResponseDTO("Record for email successfully", userService.getUserByEmailId(email));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }
}
