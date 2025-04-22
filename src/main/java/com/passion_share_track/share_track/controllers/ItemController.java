package com.passion_share_track.share_track.controllers;

import com.passion_share_track.share_track.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/location")
public class ItemController {

   @Autowired
    private ItemRepository itemRepository;



    @GetMapping("/item")
    public String getItem(){
        return "we here dawg";
    }
}
