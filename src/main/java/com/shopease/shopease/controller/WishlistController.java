package com.shopease.shopease.controller;

import com.shopease.shopease.entity.User;
import com.shopease.shopease.entity.Wishlist;
import com.shopease.shopease.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@CrossOrigin(origins = "*")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping
    public Wishlist createWishlist(@RequestBody Wishlist wishlist) {
        return wishlistService.createWishlist(wishlist);
    }

    @GetMapping
    public List<Wishlist> getAllWishlist() {
        return wishlistService.getAllWishlist();
    }

    @GetMapping("/{id}")
    public Wishlist getWishlistById(@PathVariable Long id) {
        return wishlistService.getWishlistById(id);
    }

    @GetMapping("/user/{userId}")

    public List<Wishlist> getWishlistByUser(@PathVariable Long userId) {

        User user = new User();
        user.setId(userId);

        return wishlistService.getWishlistByUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteWishlist(@PathVariable Long id) {
        wishlistService.deleteWishlist(id);
        return "Wishlist Deleted Successfully";
    }

}