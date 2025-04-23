package com.passion_share_track.share_track.controllers;

import com.passion_share_track.share_track.models.Item;
import com.passion_share_track.share_track.repositories.ItemRepository;
import com.passion_share_track.share_track.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/item")
public class ItemController {

   @Autowired
    private ItemService itemService;

    public ItemController (ItemService itemService){this.itemService = itemService;}

    @GetMapping()
    public ResponseEntity<Iterable<Item>> index(){
        return new ResponseEntity<>(itemService.index(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id){
        Item item = itemService.show(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Item> create(@RequestBody Item item) {
        Item newItem = itemService.create(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    public ResponseEntity<Item> update(Long id, Item item) {
        Item newItem = itemService.update(id, item);
        return new ResponseEntity<>(newItem, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        Boolean deletedItem = itemService.delete(id);
        return new ResponseEntity<>(deletedItem, HttpStatus.OK);
    }
}
