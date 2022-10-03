package com.bridgelabz.cart.service;

import com.bridgelabz.cart.dto.CartDTO;
import com.bridgelabz.cart.entity.CartData;

import java.util.List;

public interface ICartService {
    public CartData insertCart(CartDTO cartdto);

    public List<CartData> getAllCartRecords();

    public CartData getCartRecord(Integer id);

    public CartData updateCartRecord(Integer id, CartDTO dto);

    public CartData deleteCartRecord(Integer id);

    public CartData updateQuantity(Integer id, Integer quantity);

    public List<CartData> deleteAllFromCart();
}
