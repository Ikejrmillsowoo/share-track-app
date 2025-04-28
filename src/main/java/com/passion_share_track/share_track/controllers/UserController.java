package com.passion_share_track.share_track.controllers;

import com.passion_share_track.share_track.models.Item;
import com.passion_share_track.share_track.models.User;
import com.passion_share_track.share_track.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> index(){

        //model.addAttribute("items", Collections.singletonList(itemService.index()));
        return new ResponseEntity<>(userService.index(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getItemById(@PathVariable Long id){
        User user = userService.show(id);
        //model.addAttribute(item, Arrays.asList(item));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @GetMapping("/id/{locationid}")
//    public ResponseEntity<Iterable<User>> getItemByLocation(@PathVariable Long locationid){
//
//        return new ResponseEntity<>(userService.indexByLocation(locationid), HttpStatus.OK);
//    }

    @PostMapping("/addUser")
    public ResponseEntity<User> create(@RequestBody User user) {
        User newUser = userService.create(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
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
