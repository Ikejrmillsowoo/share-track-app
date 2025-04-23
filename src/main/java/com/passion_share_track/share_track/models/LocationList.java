package com.passion_share_track.share_track.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class LocationList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LOCATION_LIST_ID")
    private Long id;

    @OneToMany(mappedBy = "locationList", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name= "LOCATIONS")
    private List<Location> locationList = new ArrayList<>();


    public LocationList(List<Location> locationList) {
        this.locationList = locationList;
    }
    public LocationList() {
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(Location location) {
        this.locationList.add(location);
    }
}
