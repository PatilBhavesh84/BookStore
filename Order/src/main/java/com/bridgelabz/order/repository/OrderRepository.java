package com.bridgelabz.order.repository;

import com.bridgelabz.order.entity.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<OrderData, Integer> {


    @Query(value = "select price from order_details,book where book.bookid=order_details.bookid and id =:id", nativeQuery = true)
    public Integer getPrice(Integer id);

}
