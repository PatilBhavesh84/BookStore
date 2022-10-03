package com.bridgelabz.order.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "OrderDetails")
public class OrderData {

    @Id
    @GeneratedValue
    private Integer orderID;
    private LocalDate date = LocalDate.now();
    private Integer price;
    private Integer quantity;
    private String address;

    private Integer userID;

    private Integer bookID;
    private boolean cancel;

    public OrderData(Integer orderID, Integer price, Integer quantity, String address, Integer bookID, Integer userID, boolean cancel) {
        this.orderID = orderID;
        this.price = price;
        this.quantity = quantity;
        this.address = address;
        this.bookID = bookID;
        this.userID = userID;
        this.cancel = cancel;
    }

    public OrderData(Integer price, Integer quantity, String address, Integer bookID, Integer userID, boolean cancel) {
        this.price = price;
        this.quantity = quantity;
        this.address = address;
        this.bookID = bookID;
        this.userID = userID;
        this.cancel = cancel;
    }
}