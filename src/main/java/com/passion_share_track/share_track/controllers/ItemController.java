package com.passion_share_track.share_track.controllers;

import com.passion_share_track.share_track.models.Item;
import com.passion_share_track.share_track.models.Location;
import com.passion_share_track.share_track.repositories.ItemRepository;
import com.passion_share_track.share_track.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/location/item")
public class ItemController {

   @Autowired
    private ItemService itemService;

    public ItemController (ItemService itemService){this.itemService = itemService;}

    @GetMapping
    public ResponseEntity<Iterable<Item>> index(){

        //model.addAttribute("items", Collections.singletonList(itemService.index()));
        return new ResponseEntity<>(itemService.index(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id){
        Item item = itemService.show(id);
        //model.addAttribute(item, Arrays.asList(item));
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/id/{locationId}")
    public ResponseEntity<Iterable<Item>> getItemByLocation(@PathVariable Long locationId){
       return new ResponseEntity<>(itemService.indexByLocation(locationId), HttpStatus.OK);
//        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/add")
//    public ResponseEntity<Item> create(@ModelAttribute Item item) {
//        Item newItem = itemService.create(item);
//        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
//    }

    @PostMapping("/add")
    public ResponseEntity<Item> addItem(
            @RequestParam("type") String type,
            @RequestParam("model") String model,
            @RequestParam("barCodeNumber") String barCodeNumber,
            @RequestParam("count") int count,
            @RequestParam("countAvailable") int countAvailable,
            @RequestParam("locationId") Location location,
            @RequestParam("image") MultipartFile imageFile
    ) throws IOException {

        Item savedItem = itemService.create(type, model, barCodeNumber, count, countAvailable, location, imageFile);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Long id, @RequestBody Item item) {
        Item newItem = itemService.update(id, item);
        return new ResponseEntity<>(newItem, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        Boolean deletedItem = itemService.delete(id);
        return new ResponseEntity<>(deletedItem, HttpStatus.OK);
    }
}
