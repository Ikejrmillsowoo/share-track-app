package com.passion_share_track.share_track.repositories;

import com.passion_share_track.share_track.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
//    Cart findByUserId(Long userId);
}
