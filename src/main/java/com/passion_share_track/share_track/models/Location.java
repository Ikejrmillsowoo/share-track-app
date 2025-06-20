package com.passion_share_track.share_track.models;



import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "LOCATION_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "STREET_ADDRESS")
    private String addressStreet;
    @Column(name = "CITY")
    private String addressCity;
    @Column(name = "STATE")
    private String addressState;
    @Column(name = "ZIP_CODE")
    private String addressZip;

//    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Item> inventory = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "LOCATION_LIST_ID")
    private LocationList locationList;

    public Location(String name,String addressStreet, String addressCity,String addressState,String addressZip) {
//        this.inventory = inventory;
        this.addressZip = addressZip;
        this.addressState = addressState;
        this.addressCity = addressCity;
        this.addressStreet = addressStreet;
        this.name = name;

    }

    public Location(){}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressZip() {
        return addressZip;
    }

    public void setAddressZip(String addressZip) {
        this.addressZip = addressZip;
    }

//    public List<Item> getInventory() {
//        return inventory;
//    }
//
//    public void setInventory(List<Item> inventory) {
//        this.inventory = inventory;
//    }
//
//    public void addToLocation(Item item){
//        this.inventory.add(item);
//    }

}
