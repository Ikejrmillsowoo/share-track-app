package com.passion_share_track.share_track.controllers;

import com.passion_share_track.share_track.models.Cart;
import com.passion_share_track.share_track.models.CartItem;
import com.passion_share_track.share_track.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    //create a new cart
    @PostMapping("/create")
    public ResponseEntity<Cart> createCart(@RequestParam Long userId){
        Cart newCart = cartService.createCart(userId);
        return ResponseEntity.ok(newCart);
    }

    // Add item to cart
    @PostMapping("/{cartId}/add-item")
    public ResponseEntity<Cart> addItemToCart(
            @PathVariable Long cartId,
            @RequestParam Long itemId,
            @RequestParam int quantity) {
        Cart updatedCart = cartService.addItemToCart(cartId, itemId, quantity);
        return ResponseEntity.ok(updatedCart);
    }

    // get a user's cart
    @GetMapping("/user/{userId}")
    public ResponseEntity<Optional<Cart>> getCartByUser(@RequestParam Long userId){
        Optional<Cart> cart = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cart);
    }


    // Get all items in a cart
    @GetMapping("/{cartId}/items")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable Long cartId) {
        List<CartItem> items = cartService.getItemsInCart(cartId);
        return ResponseEntity.ok(items);
    }
}
