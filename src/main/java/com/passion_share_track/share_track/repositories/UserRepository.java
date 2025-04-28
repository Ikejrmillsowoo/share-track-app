package com.passion_share_track.share_track.repositories;

import com.passion_share_track.share_track.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
