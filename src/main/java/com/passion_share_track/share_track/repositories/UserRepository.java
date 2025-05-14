package com.passion_share_track.share_track.repositories;


import com.passion_share_track.share_track.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByLocationId(Long locationid);
    Optional<User> findById(User id);

    User findByUsername(String username);
}
