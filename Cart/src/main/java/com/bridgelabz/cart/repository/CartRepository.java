package com.bridgelabz.cart.repository;

import com.bridgelabz.cart.entity.CartData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<CartData, Integer> {
    @Query(value = "select * from cart where bookid =:bookId", nativeQuery = true)
    Optional<CartData> findByBookId(Integer bookId);

    @Query(value = "select * from cart where userid =:userId", nativeQuery = true)
    List<CartData> findByUserId(Integer userId);

    @Query(value = "select * from cart where userid =:userId and bookid =:bookId", nativeQuery = true)
    List<CartData> findByUserAndBookId(Integer userId, Integer bookId);

    @Query(value = "select * from cart where userid =:userID", nativeQuery = true)
    Optional<CartData> findByUserID(Integer userID);
}
