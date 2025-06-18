package com.passion_share_track.share_track.models;

import jakarta.persistence.*;

@Entity
@Table(name = "APP_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "USER_ROLE")
    private String userRole;
    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;

    @ManyToOne
    @JoinColumn(name = "USER_LOCATION_ID")
    private Location location;

    public User( String firstName, String lastName, String userRole, String username, String password, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
        this.username = username;
        this.password = password;
        this.location = location;
    }

    public User(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Long getLocationId() {
        return location.getId();
    }

    public void setLocationId(Long locationId) {
        Location location = new Location();
        location.setId(locationId);
        this.location = location;
    }

    public void setLocation(Location location){
        this.location = location;
    }
    public Location getLocation(){
        return  this.location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
