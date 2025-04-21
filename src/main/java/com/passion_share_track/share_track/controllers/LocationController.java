package com.passion_share_track.share_track.controllers;

import com.passion_share_track.share_track.models.Item;
import com.passion_share_track.share_track.models.Location;
import com.passion_share_track.share_track.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class LocationController {


    private static  LocationRepository locationRepository;
    private List<Location> locationList = new ArrayList<>();
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    //@Autowired
//    public LocationController(LocationRepository locationRepository){
//        this.locationRepository = locationRepository;
//    }

    @GetMapping("/location")
    public String location(@RequestParam(value = "name", defaultValue = "World")String name){
        return "Miami";
    }



//    public ReponseEntity<Iterable><Location>> getLoacationList(){
//        Iterable<Location> allLocations = locationRepository.findAll();
//        return new ResponseEntity<>(allLocations, HttpStatus.OK);
//    }



}
