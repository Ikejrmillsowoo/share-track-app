package com.passion_share_track.share_track.repositories;

import com.passion_share_track.share_track.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    //Find all items by location Id
    List<Item> findByLocationId(Long locationid);
}
