package com.passion_share_track.share_track.models;

import jakarta.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CART_ID")
    private Long id;
    @Column(name = "USER_ID")
    private  Long userId;

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
