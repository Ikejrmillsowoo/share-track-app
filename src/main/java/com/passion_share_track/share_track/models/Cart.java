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
    @Column(name = "USER_ID")
    private  Long userId;
    @Column(name = "CART_LOCATION_ID")
    private  Long cartLocationId;

    public Long getCartLocationId() {
        return cartLocationId;
    }

    public void setCartLocationId(Long cartLocationId) {
        this.cartLocationId = cartLocationId;
    }

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();

    // Include getters and setters for items
    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public Cart(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }

    public Cart(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
