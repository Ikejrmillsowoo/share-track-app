package com.passion_share_track.share_track.services;

import com.passion_share_track.share_track.models.Item;
import com.passion_share_track.share_track.models.Location;
import com.passion_share_track.share_track.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;


    public Iterable<Location> index() {
        return locationRepository.findAll();
    }

    public Location show(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found with ID: " + id));
    }

    public Location create(Location item) {
        return locationRepository.save(item);
    }

    public Location update(Long id, Location newLocationData) {
        Location originalLocation = locationRepository.findById(id).get();
        originalLocation.setName(newLocationData.getName());
        originalLocation.setAddressStreet(newLocationData.getAddressStreet());
        originalLocation.setAddressCity(newLocationData.getAddressCity());
        originalLocation.setAddressState(newLocationData.getAddressState());
        originalLocation.setAddressZip(newLocationData.getAddressZip());
        return locationRepository.save(originalLocation);
    }

    public Boolean delete(Long id) {
        locationRepository.deleteById(id);
        return true;
    }
}
