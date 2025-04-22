package com.passion_share_track.share_track.controllers;

import com.passion_share_track.share_track.models.Item;
import com.passion_share_track.share_track.models.Location;
import com.passion_share_track.share_track.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private  LocationRepository locationRepository;
    private List<Item> itemsList = new ArrayList<>();



    @GetMapping("/location")
    public List<Item> getLocations(){
        return itemsList;
    }




//    public ReponseEntity<Iterable><Location>> getLoacationList(){
//        Iterable<Location> allLocations = locationRepository.findAll();
//        return new ResponseEntity<>(allLocations, HttpStatus.OK);
//    }



}
