package com.shopease.shopease.controller;

import com.shopease.shopease.entity.Cart;
import com.shopease.shopease.entity.User;
import com.shopease.shopease.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.addToCart(cart);
    }

    @GetMapping
    public List<Cart> getAllCartItems() {
        return cartService.getAllCartItems();
    }

    @GetMapping("/{id}")
    public Cart getCartItemById(@PathVariable Long id) {
        return cartService.getCartItemById(id);
    }

    @PostMapping("/user")
    public List<Cart> getCartByUser(@RequestBody User user) {
        return cartService.getCartByUser(user);
    }

    @PutMapping("/{id}")
    public Cart updateCart(@PathVariable Long id,
                           @RequestBody Cart cart) {
        return cartService.updateCart(id, cart);
    }

    @DeleteMapping("/{id}")
    public String deleteCartItem(@PathVariable Long id) {
        cartService.deleteCartItem(id);
        return "Cart Item Deleted Successfully";
    }

    @DeleteMapping("/clear")
    public String clearCart(@RequestBody User user) {
        cartService.clearCart(user);
        return "Cart Cleared Successfully";
    }

}