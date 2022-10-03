package com.bridgelabz.user.repository;

import com.bridgelabz.user.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserData, Integer> {

    @Query(value = "select * from user_details where email =:mail", nativeQuery = true)
    public Optional<UserData> findByMail(String mail);
}
