package com.shopease.shopease.service;

import com.shopease.shopease.entity.Cart;
import com.shopease.shopease.entity.User;
import com.shopease.shopease.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getAllCartItems() {
        return cartRepository.findAll();
    }

    public Cart getCartItemById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    public List<Cart> getCartByUser(User user) {
        return cartRepository.findByUser(user);
    }

    public Cart updateCart(Long id, Cart cart) {

        Cart existingCart = cartRepository.findById(id).orElse(null);

        if (existingCart != null) {

            existingCart.setUser(cart.getUser());
            existingCart.setProduct(cart.getProduct());
            existingCart.setQuantity(cart.getQuantity());

            return cartRepository.save(existingCart);
        }

        return null;
    }

    public void deleteCartItem(Long id) {
        cartRepository.deleteById(id);
    }

    public void clearCart(User user) {
        cartRepository.deleteByUser(user);
    }

}