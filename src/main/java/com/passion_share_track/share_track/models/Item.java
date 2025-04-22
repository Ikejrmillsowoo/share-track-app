package com.passion_share_track.share_track.models;


import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "ITEM_ID")
    private Long id;
    @Column(name= "TYPE")
    private String type;
    @Column(name= "MODEL")
    private String model;
    @Column(name= "BARCODE_NUMBER")
    private String barCodeNumber;
    @Column(name= "IMAGE_URL")
    private String imageUrl;

    //private Long locationId;
    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;


    public Item(Long id, String type, String model, String barCodeNumber, String imageUrl, Location locationId) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.barCodeNumber = barCodeNumber;
        this.imageUrl = imageUrl;
        this.location = locationId;
    }

    public Item(){}

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

    public Location getLocationId() {
        return location;
    }

    public void setLocationId(Location locationId) {
        this.location = locationId;
    }

}
