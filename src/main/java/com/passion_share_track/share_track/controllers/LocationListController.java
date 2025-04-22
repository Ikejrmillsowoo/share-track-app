package com.passion_share_track.share_track.controllers;


import com.passion_share_track.share_track.models.Location;

import com.passion_share_track.share_track.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationListController {

    @Autowired
    private LocationRepository locationRepository;

    private List<Location> locationsList = new ArrayList<>();

    public LocationListController(List<Location> locationsList) {
        this.locationsList = locationsList;
    }

    @GetMapping
    public ResponseEntity<Iterable<Location>> getPersonList(){
        return new ResponseEntity<>(locationRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id){
        Optional<Location> location = locationRepository.findById(id);
        return location.map(value ->
                new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Location> addToLocations(@RequestBody Location location){
        Location saved = locationRepository.save(location);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }


}
