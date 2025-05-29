package com.passion_share_track.share_track.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CART_ITEM")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ITEM_ID")
    private Long id;

    @Column(name = "ITEM_ID")
    private Long itemId; // This refers to the inventory item

    @Column(name = "QUANTITY")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "CART_ID") // foreign key column
    private Cart cart;

    // Constructors
    public CartItem() {}

    public CartItem(Long itemId, int quantity, Cart cart) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.cart = cart;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Cart getCart() { return cart; }
    public void setCart(Cart cart) { this.cart = cart; }

}
