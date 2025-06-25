package com.passion_share_track.share_track.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CART_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private  User user;
//    @Column(name = "CART_LOCATION_ID")
//    private Long cartLocationId;

    @ManyToOne
    @JoinColumn(name = "CART_ITEM_ID")
    private CartItem cartItem;

//    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<CartItem> items = new ArrayList<>();

//    public Long getCartLocationId() {
//        return cartLocationId;
//    }
//
//    public void setCartLocationId(Long cartLocationId) {
//        this.cartLocationId = cartLocationId;
//    }



    // Include getters and setters for items
//    public List<CartItem> getItems() {
//        return items;
//    }
//
//    public void setItems(List<CartItem> items) {
//        this.items = items;
//    }


    public Cart( User user, CartItem cartItem) {
        this.user = user;
        this.cartItem = cartItem;
    }

    public Cart (User user){
        this.user = user;
    }

    public Cart(){}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return user.getId();
    }

    public void setUserId(Long userId) {
        User user = new User();
        user.setId(userId);
        this.user = user;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }
}
