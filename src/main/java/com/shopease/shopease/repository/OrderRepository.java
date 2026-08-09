package com.shopease.shopease.repository;

import com.shopease.shopease.entity.Order;
import com.shopease.shopease.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);

}
