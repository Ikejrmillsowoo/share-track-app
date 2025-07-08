package com.passion_share_track.share_track.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CART_ITEM")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ITEM_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item; // This refers to the inventory item

    @Column(name = "QUANTITY")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "CART_ID") // foreign key column
    private Cart cart;

    // Constructors

    public CartItem(Item item, int quantity, Cart cart) {
        this.item = item;
        this.quantity = quantity;
        this.cart = cart;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Long getCartId() { return cart.getId(); }
    public void setCart(Cart cart) { this.cart = cart; }

}
