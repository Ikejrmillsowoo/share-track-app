package com.passion_share_track.share_track.services;

import com.passion_share_track.share_track.models.Item;
import com.passion_share_track.share_track.models.User;
import com.passion_share_track.share_track.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Iterable<User> index() {
        return userRepository.findAll();
    }
//    public Iterable<User> indexByLocation(Long locationId) {
//        return userRepository.findByLocationId(locationId);
//    }

    public User show(Long id) {
        return userRepository.findById(id).get();
    }

    public User create(User item) {
        return userRepository.save(item);
    }

    public User update(Long id, User newUserData) {
        User originalUser = userRepository.findById(id).get();
        originalUser.setFirstName(newUserData.getFirstName());
        originalUser.setLastName(newUserData.getLastName());
        originalUser.setUserRole(newUserData.getUserRole());
        originalUser.setLocationId(newUserData.getLocationId());
        return userRepository.save(originalUser);
    }

    public Boolean delete(Long id) {
        Optional<User> itemOptional = userRepository.findById(id);

        if (itemOptional.isPresent()) {
            userRepository.deleteById(id);
            return true; // successfully deleted
        } else {
            return false; // no item found to delete
        }
    }
}
