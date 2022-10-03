package com.bridgelabz.order.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderDTO {
    private Integer quantity;
    @NotEmpty(message = "Please provide address")
    private String address;
    private Integer price;
    private Integer userID;
    private String email;
    private Integer bookID;
    private boolean cancel;
}
