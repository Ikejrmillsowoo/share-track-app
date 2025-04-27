package com.passion_share_track.share_track.repositories;

import com.passion_share_track.share_track.models.LocationList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LocationListRepository extends JpaRepository<LocationList, Long> {
}
