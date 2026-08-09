package com.shopease.shopease.service;

import com.shopease.shopease.entity.Order;
import com.shopease.shopease.entity.User;
import com.shopease.shopease.repository.OrderRepository;
import com.shopease.shopease.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;



    public Order createOrder(Order order) {

        if (order.getUser() == null) {
            User defaultUser = userRepository.findById(1L).orElse(null);
            order.setUser(defaultUser);
        }

        if (order.getUser() == null) {
            throw new RuntimeException("User is required");
        }

        order.setOrderDate(LocalDateTime.now());

        if (order.getStatus() == null || order.getStatus().isEmpty()) {
            order.setStatus("PLACED");
        }

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getOrdersByUser(Long userId) {

        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return List.of();
        }

        return orderRepository.findByUser(user);
    }

    public Order updateOrder(Long id, Order order) {

        Order existingOrder = orderRepository.findById(id).orElse(null);

        if (existingOrder != null) {

            existingOrder.setUser(order.getUser());
            existingOrder.setTotalAmount(order.getTotalAmount());
            existingOrder.setStatus(order.getStatus());

            return orderRepository.save(existingOrder);
        }

        return null;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}