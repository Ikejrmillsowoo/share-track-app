package com.passion_share_track.share_track.controllers;

import com.passion_share_track.share_track.models.Item;
import com.passion_share_track.share_track.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/location")
public class ItemController {

   @Autowired
    private ItemRepository itemRepository;



//    @GetMapping("/{id}")
//    public ResponseEntity<Item> getItem(@PathVariable Long id){
//        Item item = itemRepository.findOne(id);
//        return new ResponseEntity<>()
//    }
}
