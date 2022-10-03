package com.bridgelabz.order.controller;

import com.bridgelabz.order.dto.OrderDTO;
import com.bridgelabz.order.dto.ResponseDTO;
import com.bridgelabz.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/orderDetails")
public class OrderController {

    @Autowired
    IOrderService orderService;

    //Ability to call api to insert order record
    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insertOrder(@Valid @RequestBody OrderDTO orderdto) {
        ResponseDTO dto = new ResponseDTO("Order registered successfully !", orderService.insertOrder(orderdto));
        return new ResponseEntity(dto, HttpStatus.CREATED);
    }

    //Ability to call api retrieve all order records
    @GetMapping("/retrieveAllOrders")
    public ResponseEntity<ResponseDTO> getAllOrderRecords() {
        ResponseDTO dto = new ResponseDTO("All records retrieved successfully !", orderService.getAllOrderRecords());
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    //Ability to call api to retrieve order records by id
    @GetMapping("/retrieveOrder/{id}")
    public ResponseEntity<ResponseDTO> getBookRecord(@PathVariable Integer id) {
        ResponseDTO dto = new ResponseDTO("Record retrieved successfully !", orderService.getOrderRecord(id));
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    //Ability to call api to update order record by id
    @PutMapping("/updateOrder/{id}")
    public ResponseEntity<ResponseDTO> updateBookRecord(@PathVariable Integer id, @Valid @RequestBody OrderDTO orderdto) {
        ResponseDTO dto = new ResponseDTO("Record updated successfully !", orderService.updateOrderRecord(id, orderdto));
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }

    //Ability to call api to delete order record by id
    @PutMapping("/deleteOrder/{id}")
    public ResponseEntity<ResponseDTO> deleteOrderRecord(@PathVariable Integer id) {
        ResponseDTO dto = new ResponseDTO("Record deleted successfully !", orderService.deleteOrderRecord(id));
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }

    @PutMapping("/cancelOrder/{id}")
    public ResponseEntity<ResponseDTO> cancelOrderById(@PathVariable Integer id, @Valid @RequestBody OrderDTO orderdto) {
        ResponseDTO dto = new ResponseDTO("Order Record Canceled Successfully !", orderService.cancelOrderById(id, orderdto));
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }
}

