package com.passion_share_track.share_track.repositories;

import com.passion_share_track.share_track.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser_Id(Long userId);
//    Cart findByUserId(Long userId);
}
