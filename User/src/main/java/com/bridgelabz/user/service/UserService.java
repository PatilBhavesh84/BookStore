package com.bridgelabz.user.service;

import com.bridgelabz.user.dto.ChangePasswordDTO;
import com.bridgelabz.user.dto.LoginDTO;
import com.bridgelabz.user.dto.UserDTO;
import com.bridgelabz.user.entity.UserData;
import com.bridgelabz.user.exception.BookStoreException;
import com.bridgelabz.user.repository.UserRepository;
import com.bridgelabz.user.util.EmailSenderService;
import com.bridgelabz.user.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepo;
    @Autowired
    EmailSenderService mailService;

    @Autowired
    TokenUtil util;

    //Ability to serve controller's insert user record api call
    public String registerUser(UserDTO userdto) {
        UserData newUser = new UserData(userdto);
        userRepo.save(newUser);
        String token = util.createToken(newUser.getUserID());
        mailService.sendEmail(userdto.getEmail(), "Account Sign-up successfully", "Hello" + newUser.getFirstName() + " Your Account has been created.Your token is " + token + " Keep this token safe to access your account in future ");
        return token;
    }

    //Ability to serve controller's user login api call
    public UserData userLogin(LoginDTO logindto) {
        Optional<UserData> newUser = userRepo.findByMail(logindto.getEmail());
        if (logindto.getEmail().equals(newUser.get().getEmail()) && logindto.getPassword().equals(newUser.get().getPassword())) {
            log.info("SuccessFully Logged In");
            return newUser.get();
        } else {

            throw new BookStoreException("User doesn't exists");

        }
    }

    //Ability to serve controller's retrieve user record by token api call
    public UserData getRecordByToken(String token) {
        Integer id = util.decodeToken(token);
        Optional<UserData> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new BookStoreException("User Record doesn't exists");
        } else {
            log.info("Record retrieved successfully for given token having id " + id);
            return user.get();
        }
    }

    //Ability to serve controller's retrieve all user records api call
    public List<UserData> getAllRecords() {
        List<UserData> userList = userRepo.findAll();
        log.info("All Record Retrieved Successfully");
        return userList;
    }

    //Ability to serve controller's retrieve user record by id api call
    public UserData getRecord(Integer id) {
        Optional<UserData> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new BookStoreException("User Record doesn't exists");
        } else {
            log.info("Record retrieved successfully for id " + id);
            return user.get();
        }
    }

    //Ability to serve controller's update user record by id api call
    public UserData updateRecord(Integer id, UserDTO dto) {
        Optional<UserData> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new BookStoreException("User Record doesn't exists");
        } else {
            UserData newUser = new UserData(id, dto);
            userRepo.save(newUser);
            log.info("User data updated successfully");
            return newUser;
        }
    }

    //Ability to serve controller's change password api call
    public UserData changePassword(@Valid @RequestBody ChangePasswordDTO dto) {
        Optional<UserData> user = userRepo.findByMail(dto.getEmail());
        String generatedToken = util.createToken(user.get().getUserID());
        mailService.sendEmail(user.get().getEmail(), "Welcome " + user.get().getFirstName(), generatedToken);
        if (user.isEmpty()) {
            throw new BookStoreException("User doesn't exists");
        } else {
            if (dto.getToken().equals(generatedToken)) {
                user.get().setPassword(dto.getNewPassword());
                userRepo.save(user.get());
                log.info("Password changes successfully");
                return user.get();
            } else {
                throw new BookStoreException("Invalid token");
            }
        }
    }

    //Created to serve controller's retrieve user record by email api call
    public UserData getUserByEmailId(String email) {
        Optional<UserData> newUser = userRepo.findByMail(email);
        if (newUser.isEmpty()) {
            throw new BookStoreException("User record does not exist");
        } else {
            return newUser.get();
        }
    }
}
