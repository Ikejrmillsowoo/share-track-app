package com.passion_share_track.share_track.services;


import com.passion_share_track.share_track.models.LocationList;
import com.passion_share_track.share_track.repositories.LocationListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class LocationListService {

    @Autowired
    private LocationListRepository locationListRepository;
    public Iterable<LocationList> index() {
        return locationListRepository.findAll();
    }

    public LocationList show(Long id) {
        return locationListRepository.findById(id).get();
    }

    public LocationList create(LocationList locationList) {
        return locationListRepository.save(locationList);
    }

    public LocationList update(Long id, LocationList newLocationList) {
        LocationList originalLocationList = locationListRepository.findById(id).get();

        return locationListRepository.save(newLocationList);
    }

    public Boolean delete(Long id) {
        locationListRepository.deleteById(id);
        return true;
    }
}
