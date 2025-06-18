package com.passion_share_track.share_track.repositories;

import com.passion_share_track.share_track.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
