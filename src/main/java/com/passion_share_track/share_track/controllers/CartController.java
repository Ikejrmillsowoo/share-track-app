package com.passion_share_track.share_track.controllers;

import com.passion_share_track.share_track.models.Cart;
import com.passion_share_track.share_track.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    //create a new cart
    @PostMapping("/create")
    public ResponseEntity<Cart> createCart(@RequestParam Long userId, @RequestParam Long locationId){
        Cart newCart = cartService.createCart(userId, locationId);
        return ResponseEntity.ok(newCart);
    }

    // get a user's cart
    @PostMapping("/user/{userId}")
    public ResponseEntity<Cart> getCartByUser(@RequestParam Long userId){
        Cart cart = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cart);
    }


}
