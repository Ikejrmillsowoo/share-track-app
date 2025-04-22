package com.passion_share_track.share_track.controllers;


import com.passion_share_track.share_track.models.Location;
import com.passion_share_track.share_track.repositories.LocationListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
public class LocationListController {
    @Autowired
    private LocationListRepository locationListRepository;
    private List<Location> locationsList = new ArrayList<>();

    public LocationListController(List<Location> locationsList) {
        this.locationsList = locationsList;
    }

    @GetMapping("/locations")
    public List<Location> getLocation(){
        return locationsList;
    }


}
