package com.passion_share_track.share_track.services;

import com.passion_share_track.share_track.models.Item;
import com.passion_share_track.share_track.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;



    public Iterable<Item> index() {
        return itemRepository.findAll();
    }
    public Iterable<Item> indexByLocation(Long locationId) {
        return itemRepository.findByLocationId(locationId);
    }

    public Item show(Long id) {
        return itemRepository.findById(id).get();
    }

    public Item create(Item item) {
        return itemRepository.save(item);
    }

    public Item update(Long id, Item newItemData) {
        Item originalItem = itemRepository.findById(id).get();
        originalItem.setType(newItemData.getType());
        originalItem.setModel(newItemData.getModel());
        originalItem.setImageUrl(newItemData.getImageUrl());
        originalItem.setBarCodeNumber(newItemData.getBarCodeNumber());
        originalItem.setModel(newItemData.getModel());
        originalItem.setLocationId(newItemData.getLocationId());
        return itemRepository.save(originalItem);
    }

    public Boolean delete(Long id) {
        Optional<Item> itemOptional = itemRepository.findById(id);

        if (itemOptional.isPresent()) {
            itemRepository.deleteById(id);
            return true; // successfully deleted
        } else {
            return false; // no item found to delete
        }
       // itemRepository.deleteById(id);
       //return true;
    }
}
