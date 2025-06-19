package com.passion_share_track.share_track.repositories;


import com.passion_share_track.share_track.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    List<User> findByLocationId(Long locationid);
//    Optional<User> findById(User id);
//
//    User findByUsername(String username);
//
    User findByUsernameAndPassword(String username, String password);

}
