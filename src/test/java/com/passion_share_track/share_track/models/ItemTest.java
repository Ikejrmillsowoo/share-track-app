package com.passion_share_track.share_track.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void createItemTest() {
        //Given
        Long id = 1L;
        String type = "Keyboard";
        String model = "Yamaha MODX-8";
        String barCodeNumber = "123-456";
        String imageUrl = "/src/main/resources/keys";

        Long locationId = 2L;

        Item item = new Item(id, type, model, barCodeNumber, imageUrl, locationId);

        //When
        Long actualId =  item.getId();
        String actualType = item.getType();
        String actualModel = item.getModel();
        String actualBarCodeNumber = item.getBarCodeNumber();
        String actualImageUrl = item.getImageUrl();
        Long actualLocationId = item.getLocationId();

        //Then
        Assertions.assertEquals(id, actualId);
        Assertions.assertEquals(type, actualType);
        Assertions.assertEquals(model, actualModel);
        Assertions.assertEquals(barCodeNumber, actualBarCodeNumber);
        Assertions.assertEquals(imageUrl, actualImageUrl);
        Assertions.assertEquals(locationId, actualLocationId);
    }
}
