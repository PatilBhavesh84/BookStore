package com.bridgelabz.user.entity;

import com.bridgelabz.user.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "UserDetails")
public class UserData {

    @Id
    @GeneratedValue
    private Integer userID;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String password;


    public UserData(UserDTO dto) {
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.password = dto.getPassword();

    }

    public UserData(Integer userID, UserDTO dto) {
        this.userID = userID;
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.password = dto.getPassword();

    }
}
