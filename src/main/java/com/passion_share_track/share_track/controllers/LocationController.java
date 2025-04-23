package com.passion_share_track.share_track.controllers;

import com.passion_share_track.share_track.models.Item;
import com.passion_share_track.share_track.models.Location;
import com.passion_share_track.share_track.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationSvc;
    private List<Item> itemsList = new ArrayList<>();

    public LocationController (LocationService locationService){this.locationSvc = locationService;}

    @GetMapping()
    public ResponseEntity<Iterable<Location>> index(){
        return new ResponseEntity<>(locationSvc.index(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getItem(@PathVariable Long id){
        Location item = locationSvc.show(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Location> create(@RequestBody Location location) {
        Location newItem = locationSvc.create(location);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    public ResponseEntity<Location> update(Long id, Location location) {
        Location newLocation = locationSvc.update(id, location);
        return new ResponseEntity<>(newLocation, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        Boolean deletedItem = locationSvc.delete(id);
        return new ResponseEntity<>(deletedItem, HttpStatus.OK);
    }

}
