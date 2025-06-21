package com.passion_share_track.share_track.services;

import com.passion_share_track.share_track.DTO.UserRegistrationDTO;
import com.passion_share_track.share_track.models.Location;
import com.passion_share_track.share_track.models.User;
import com.passion_share_track.share_track.repositories.LocationRepository;
import com.passion_share_track.share_track.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Component
public class UserService  {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

//    @Override
//    public UserDetailsServiceA

    public Iterable<User> index() {
        return userRepository.findAll();
    }
    public Optional<User> indexByLocation(Long locationId) {
//        return userRepository.findByLocationId(locationId);
        return userRepository.findById(locationId);
    }

    public User show(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
    }

    public User create(User user) {
        Location newLocation = locationRepository.findById(user.getLocationId())
                .orElseThrow(() -> new RuntimeException("Location not found"));
        user.setLocation(newLocation);
        return userRepository.save(user);
    }

    public User update(Long id, User newUserData) {
        User originalUser = userRepository.findById(id).get();
        Location newLocation = locationRepository.findById(newUserData.getLocationId())
                .orElseThrow(() -> new RuntimeException("Location not found"));
        originalUser.setFirstName(newUserData.getFirstName());
        originalUser.setLastName(newUserData.getLastName());
        originalUser.setUserRole(newUserData.getUserRole());
        originalUser.setUsername(newUserData.getUsername());
        originalUser.setPassword(newUserData.getPassword());
        originalUser.setLocation(newLocation);

        return userRepository.save(originalUser);
    }

    public User register(UserRegistrationDTO userRegistrationDTO){
        User user = new User();
        user.setFirstName(userRegistrationDTO.getFirstName());
        user.setLastName(userRegistrationDTO.getLastName());
        user.setUsername(userRegistrationDTO.getUsername());
        user.setPassword(userRegistrationDTO.getPassword()); // ⚠️ plaintext for now
        user.setUserRole(userRegistrationDTO.getUserRole());
        user.setLocationId(userRegistrationDTO.getLocationId());
        return userRepository.save(user);
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

    public User login(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null){
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername(),
//                user.getPassword(),
//                List.of(new SimpleGrantedAuthority(("ROLE_USER")))
//        );
  //  }


}
