package com.shopease.shopease.controller;

import com.shopease.shopease.entity.Order;
import com.shopease.shopease.entity.OrderItem;
import com.shopease.shopease.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
@CrossOrigin(origins = "*")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.createOrderItem(orderItem);
    }

    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/{id}")
    public OrderItem getOrderItemById(@PathVariable Long id) {
        return orderItemService.getOrderItemById(id);
    }

    @GetMapping("/order")
    public List<OrderItem> getOrderItemsByOrder(@RequestBody Order order) {
        return orderItemService.getOrderItemsByOrder(order);
    }

    @PutMapping("/{id}")
    public OrderItem updateOrderItem(@PathVariable Long id,
                                     @RequestBody OrderItem orderItem) {
        return orderItemService.updateOrderItem(id, orderItem);
    }

    @DeleteMapping("/{id}")
    public String deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return "Order Item Deleted Successfully";
    }

}