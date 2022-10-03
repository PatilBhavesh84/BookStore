package com.bridgelabz.order.service;

import com.bridgelabz.order.dto.OrderDTO;
import com.bridgelabz.order.entity.OrderData;

import java.util.List;

public interface IOrderService {
    public OrderData insertOrder(OrderDTO orderdto);

    public List<OrderData> getAllOrderRecords();

    public OrderData getOrderRecord(Integer id);

    public OrderData updateOrderRecord(Integer id, OrderDTO dto);

    public OrderData deleteOrderRecord(Integer id);

    public OrderData cancelOrderById(Integer id, OrderDTO dto);
}

