package com.passion_share_track.share_track.controllers;


import com.passion_share_track.share_track.models.Item;
import com.passion_share_track.share_track.models.Location;

import com.passion_share_track.share_track.models.LocationList;
import com.passion_share_track.share_track.services.LocationListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationListController {

    @Autowired
    private LocationListService locationListSvc;
    private List<Item> itemsList = new ArrayList<>();

    public LocationListController (LocationListService locationListSvc){this.locationListSvc = locationListSvc;}

    @GetMapping()
    public ResponseEntity<Iterable<LocationList>> index(){
        return new ResponseEntity<>(locationListSvc.index(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationList> getItem(@PathVariable Long id){
        LocationList item = locationListSvc.show(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<LocationList> create(@RequestBody LocationList locationList) {
        LocationList newItem = locationListSvc.create(locationList);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    public ResponseEntity<LocationList> update(Long id, LocationList locationList) {
        LocationList newLocation = locationListSvc.update(id, locationList);
        return new ResponseEntity<>(newLocation, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        Boolean deletedItem = locationListSvc.delete(id);
        return new ResponseEntity<>(deletedItem, HttpStatus.OK);
    }


}
