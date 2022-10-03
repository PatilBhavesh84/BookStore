package com.bridgelabz.order.service;

import com.bridgelabz.order.dto.OrderDTO;
import com.bridgelabz.order.entity.OrderData;
import com.bridgelabz.order.exception.BookStoreException;
import com.bridgelabz.order.repository.OrderRepository;
import com.bridgelabz.order.util.EmailSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    EmailSenderService mailService;

    public OrderData insertOrder(OrderDTO orderdto) {

        OrderData newOrder = new OrderData(orderdto.getPrice(), orderdto.getQuantity(), orderdto.getAddress(), orderdto.getBookID(), orderdto.getUserID(), orderdto.isCancel());
        orderRepo.save(newOrder);
        log.info("Order record inserted successfully");
        mailService.sendEmail(orderdto.getEmail(), "Your Order Placed successfully", "Hello, Your order for " + newOrder + "  is placed successfully on " + newOrder.getDate() + " and will be delivered to you shortly.");
        return newOrder;
    }

    //Ability to serve controller's retrieve all order records api call
    public List<OrderData> getAllOrderRecords() {
        List<OrderData> orderList = orderRepo.findAll();
        log.info("ALL order records retrieved successfully");
        return orderList;
    }

    //Ability to serve controller's retrieve order record by id api call
    public OrderData getOrderRecord(Integer id) {
        Optional<OrderData> order = orderRepo.findById(id);
        if (order.isEmpty()) {
            throw new BookStoreException("Order Record doesn't exists");
        } else {
            log.info("Order record retrieved successfully for id " + id);
            return order.get();
        }
    }

    //Ability to serve controller's update order record by id api call
    public OrderData updateOrderRecord(Integer id, OrderDTO dto) {
        Optional<OrderData> order = orderRepo.findById(id);
        if (order.isEmpty()) {
            throw new BookStoreException("Order Record doesn't exists");
        } else {
            OrderData newOrder = new OrderData(id, dto.getPrice(), dto.getQuantity(), dto.getAddress(), dto.getBookID(), dto.getUserID(), dto.isCancel());
            orderRepo.save(newOrder);
            log.info("Order record updated successfully for id " + id);

            return newOrder;
        }
    }

    //Ability to serve controller's delete order record by id api call
    public OrderData deleteOrderRecord(Integer id) {
        Optional<OrderData> order = orderRepo.findById(id);
        if (order.isEmpty()) {
            throw new BookStoreException("Order Record doesn't exists");
        } else {
            orderRepo.deleteById(id);
            log.info("Order record deleted successfully for id " + id);
            return order.get();
        }
    }

    public OrderData cancelOrderById(Integer id, OrderDTO dto) {
        Optional<OrderData> order = orderRepo.findById(id);
        order.get().setCancel(true);
        orderRepo.save(order.get());
        mailService.sendEmail(dto.getEmail(), "Order Cancelled Successfully", "Your order has been cancelled Successfully");
        return order.get();
    }
}

