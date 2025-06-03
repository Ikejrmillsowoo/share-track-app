package com.passion_share_track.share_track.repositories;

import com.passion_share_track.share_track.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//jpa
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    //Find all items by location Id
  //  List<Item> findByLocationId(Long locationid);
}
