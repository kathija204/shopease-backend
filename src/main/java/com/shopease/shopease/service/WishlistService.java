package com.shopease.shopease.service;

import com.shopease.shopease.entity.User;
import com.shopease.shopease.entity.Wishlist;
import com.shopease.shopease.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public Wishlist createWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public List<Wishlist> getAllWishlist() {
        return wishlistRepository.findAll();
    }

    public Wishlist getWishlistById(Long id) {
        return wishlistRepository.findById(id).orElse(null);
    }

    public List<Wishlist> getWishlistByUser(User user) {
        return wishlistRepository.findByUser(user);
    }

    public void deleteWishlist(Long id) {
        wishlistRepository.deleteById(id);
    }

}