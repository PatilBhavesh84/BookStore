package com.bridgelabz.user.service;

import com.bridgelabz.user.dto.ChangePasswordDTO;
import com.bridgelabz.user.dto.LoginDTO;
import com.bridgelabz.user.dto.UserDTO;
import com.bridgelabz.user.entity.UserData;

import java.util.List;

public interface IUserService {

    public String registerUser(UserDTO userdto);

    public UserData userLogin(LoginDTO logindto);

    public List<UserData> getAllRecords();

    public UserData getRecord(Integer id);

    public UserData getRecordByToken(String token);

    public UserData updateRecord(Integer id, UserDTO dto);

    public UserData changePassword(ChangePasswordDTO dto);

    public UserData getUserByEmailId(String email);
}
