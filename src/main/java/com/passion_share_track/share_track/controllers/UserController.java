package com.passion_share_track.share_track.controllers;

import com.passion_share_track.share_track.DTO.UserLoginDTO;
import com.passion_share_track.share_track.DTO.UserRegistrationDTO;
import com.passion_share_track.share_track.models.Cart;
import com.passion_share_track.share_track.models.User;
import com.passion_share_track.share_track.repositories.CartRepository;
import com.passion_share_track.share_track.services.CartService;
import com.passion_share_track.share_track.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> index(){

        return new ResponseEntity<>(userService.index(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getItemById(@PathVariable Long id){
        User user = userService.show(id);
        //model.addAttribute(item, Arrays.asList(item));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/id/{locationid}")
    public ResponseEntity<Optional<User>> getItemByLocation(@PathVariable Long locationid){

        return new ResponseEntity<>(userService.indexByLocation(locationid), HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> create(@RequestBody User user) {
        User newUser = userService.create(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO){
        User user = userService.login(userLoginDTO.getUsername(), userLoginDTO.getPassword());

        if (user != null){
            if (cartService.getCartByUserId(user.getId()) != null){
                System.out.println(user.getFirstName() + "cart created");
                cartService.createCart(user);
            }
            return ResponseEntity.ok(user);
        } else {
            return  ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegistrationDTO userRegistrationDTO){
        User savedUser = userService.register(userRegistrationDTO);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        User newUser = userService.update(id, user);
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        Boolean deletedUser = userService.delete(id);
        return new ResponseEntity<>(deletedUser, HttpStatus.OK);
    }
}
