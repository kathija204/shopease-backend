package com.shopease.shopease.repository;

import com.shopease.shopease.entity.Cart;
import com.shopease.shopease.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUser(User user);

    void deleteByUser(User user);

}