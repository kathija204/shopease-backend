package com.shopease.shopease.service;

import com.shopease.shopease.entity.Order;
import com.shopease.shopease.entity.OrderItem;
import com.shopease.shopease.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    public List<OrderItem> getOrderItemsByOrder(Order order) {
        return orderItemRepository.findByOrder(order);
    }

    public OrderItem updateOrderItem(Long id, OrderItem orderItem) {

        OrderItem existingOrderItem = orderItemRepository.findById(id).orElse(null);

        if (existingOrderItem != null) {

            existingOrderItem.setOrder(orderItem.getOrder());
            existingOrderItem.setProduct(orderItem.getProduct());
            existingOrderItem.setQuantity(orderItem.getQuantity());
            existingOrderItem.setPrice(orderItem.getPrice());

            return orderItemRepository.save(existingOrderItem);
        }

        return null;
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }

}