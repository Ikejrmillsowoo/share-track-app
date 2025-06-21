package com.passion_share_track.share_track.controllers;

import com.passion_share_track.share_track.DTO.CartDTO;
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
    public ResponseEntity<?> addItemToCart(@RequestBody CartDTO cartRequest) {
        Long userId = cartRequest.getUserId();
        Long itemId = cartRequest.getItemId();
        int quantity = cartRequest.getQuantity();

        System.out.println("User ID :" + userId);
        System.out.println("Item ID :" + itemId);
        System.out.println("Quantity :" + quantity);

        if (userId == null || itemId == null) {
            return ResponseEntity.badRequest().body("User ID and Item ID must not be null.");
        }

        Cart userCart = cartService.getCartByUserId(userId);
        if (userCart == null){
            User user = userService.show(userId);
            userCart = cartService.createCart(user);
        }

        System.out.println("This is the user Cart: " + userCart);

        try {
            Cart updatedCart = cartService.addItemToCart(userCart.getId(), itemId, quantity);
            return ResponseEntity.ok(updatedCart);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to add item to cart: " + e.getMessage());
        }
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
