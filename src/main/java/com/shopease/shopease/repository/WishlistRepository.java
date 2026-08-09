package com.shopease.shopease.repository;

import com.shopease.shopease.entity.User;
import com.shopease.shopease.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    List<Wishlist> findByUser(User user);

}