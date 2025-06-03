package com.passion_share_track.share_track.models;


import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long id;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "BARCODE_NUMBER")
    private String barCodeNumber;
    @Column(name = "IMAGE_URL")
    private String imageUrl;
    @Column(name = "COUNT")
    private Integer count;
    @Column(name = "COUNT_AVAILABLE")
    private Integer countAvailable;

    @ManyToOne
    @JoinColumn(name = "CURRENT_LOCATION_ID")
    private Location location;

    //    @Column(name="HOME_LOCATION_ID")
    @ManyToOne
    @JoinColumn(name = "HOME_LOCATION_ID")
    private Location homeLocation;


    public Item(Long id, String type, String model, String barCodeNumber, String imageUrl, Integer count, Integer countAvailable, Location location, Location homeLocation) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.barCodeNumber = barCodeNumber;
        this.imageUrl = imageUrl;
        this.count = count;
        this.countAvailable = countAvailable;
        this.location = location;
        this.homeLocation = homeLocation;
    }

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBarCodeNumber() {
        return barCodeNumber;
    }

    public void setBarCodeNumber(String barCodeNumber) {
        this.barCodeNumber = barCodeNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getLocationId() {
        return (location != null) ? location.getId() : null;
    }

    public void setLocationId(Long locationId) {
        this.location.setId(locationId);
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCountAvailable() {
        return countAvailable;
    }

    public void setCountAvailable(Integer countAvailable) {
        this.countAvailable = countAvailable;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getHomeLocation() {
        return homeLocation;
    }

    public void setHomeLocation(Location homeLocation) {
        this.homeLocation = homeLocation;
    }
}
