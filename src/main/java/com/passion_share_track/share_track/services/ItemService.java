package com.passion_share_track.share_track.services;

import com.passion_share_track.share_track.models.Item;
import com.passion_share_track.share_track.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
@Component
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;



    public Iterable<Item> index() {
        return itemRepository.findAll();
    }
    public Optional<Item> indexByLocation(Long locationId) {
        return itemRepository.findById(locationId);
    }

    public Item show(Long id) {
        return itemRepository.findById(id).get();
    }

//    public Item create(Item item) {
//        return itemRepository.save(item);
//    }

    public Item create(String type, String model, String barCodeNumber, int count, int countAvailable, MultipartFile imageFile) throws IOException {
        // 1. Save image file to static folder
        String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
//        Path imagePath = Paths.get("src/main/resources/static/images/" + fileName);
        Path imagePath = Paths.get("target/classes/static/images/" + fileName);
        Files.copy(imageFile.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);



        // 2. Create and save item
        Item item = new Item();
        item.setType(type);
        item.setModel(model);
        item.setBarCodeNumber(barCodeNumber);
        item.setCount(count);
        item.setCountAvailable(countAvailable);
        item.setImageUrl("images/" + fileName);

        return itemRepository.save(item);
    }

    public Item update(Long id, Item newItemData) {
        Item originalItem = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));
        originalItem.setType(newItemData.getType());
        originalItem.setModel(newItemData.getModel());
        originalItem.setImageUrl(newItemData.getImageUrl());
        originalItem.setBarCodeNumber(newItemData.getBarCodeNumber());
        originalItem.setModel(newItemData.getModel());
        originalItem.setLocationId(newItemData.getLocationId());
        originalItem.setCount(newItemData.getCount());
        originalItem.setCountAvailable(newItemData.getCountAvailable());
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
