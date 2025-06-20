package com.passion_share_track.share_track.controllers;

import com.passion_share_track.share_track.models.Cart;
import com.passion_share_track.share_track.models.CartItem;
import com.passion_share_track.share_track.models.User;
import com.passion_share_track.share_track.services.CartService;
import com.passion_share_track.share_track.services.UserService;
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

    @Autowired
    private UserService userService;
    //create a new cart
    @PostMapping("/create")
    public ResponseEntity<Cart> createCart(@RequestParam Long userId){
        User user = userService.show(userId);
        Cart newCart = cartService.createCart(user);
        return ResponseEntity.ok(newCart);
    }

    // Add item to cart
    @PostMapping("/addItem")
    public ResponseEntity<Cart> addItemToCart(
            @RequestParam User user,
            @RequestParam Long itemId,
            @RequestParam int quantity) {
        Cart userCart = cartService.getCartByUserId(user.getId());
        if (userCart == null){
            cartService.createCart(user);
        };
        assert userCart != null;
        Cart updatedCart = cartService.addItemToCart(userCart.getId(), itemId, quantity);
        return ResponseEntity.ok(updatedCart);
    }

    // get a user's cart
    @GetMapping("/user/{userId}")
    public ResponseEntity<Cart> getCartByUser(@RequestParam Long userId){
        Cart cart = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cart);
    }


    // Get all items in a cart
    @GetMapping("/{cartId}/items")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable Long cartId) {
        List<CartItem> items = cartService.getItemsInCart(cartId);
        return ResponseEntity.ok(items);
    }
}
