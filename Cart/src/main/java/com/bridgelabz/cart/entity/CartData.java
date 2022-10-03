package com.bridgelabz.cart.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class CartData {

    @Id
    @GeneratedValue
    private Integer cartID;
    private Integer userID;

    private Integer bookID;
    private Integer quantity;

    public CartData(Integer cartID, Integer quantity, Integer bookID, Integer userID) {
        this.cartID = cartID;
        this.quantity = quantity;
        this.bookID = bookID;
        this.userID = userID;
    }

    public CartData(Integer quantity, Integer bookID, Integer userID) {
        this.quantity = quantity;
        this.bookID = bookID;
        this.userID = userID;

    }
}