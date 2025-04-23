package com.passion_share_track.share_track.models;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class LocationHolderTest {

    @Test
    public void testLocationList(){
        Long id = 1L;
        String name = "Delaware Central";
        String addressStreet = "123 Egg McMuffin Lane";
        String addressCity = "Bear";
        String addressState = "Delaware";
        String addressZip = "19702";
        List<Item> inventory = new ArrayList<>();
        Location location = new Location( id, name, addressStreet, addressCity, addressState, addressZip, inventory);

        Item keyboard = new Item(1L, "keyboard", "MODX-8", "123", "/src/main/resources/keys", location.getId());
        Item bassGuitar = new Item(2L, "bass", "6 String Scepter Euro4XL", "321", "/src/main/resources/bass", location.getId());
        Item speaker = new Item(3L, "speaker", "JBL EON715", "789", "/src/main/resources/speakers", location.getId());

        inventory.add(keyboard);
        inventory.add(bassGuitar);
        inventory.add(speaker);

        Long id2 = 2L;
        String name2 = "Peniel Assembly";
        String addressStreet2 = "123 Over there Lane";
        String addressCity2 = "Smyrna";
        String addressState2 = "Delaware";
        String addressZip2 = "19711";
        List<Item> inventory2 = new ArrayList<>();
        Location location2 = new Location( id2, name2, addressStreet2, addressCity2, addressState2, addressZip2, inventory2);
        Item keyboard2 = new Item(1L, "keyboard", "MODX-8", "123", "/src/main/resources/keys", location2.getId());
        Item bassGuitar2 = new Item(2L, "bass", "6 String Scepter Euro4XL", "321", "/src/main/resources/bass", location2.getId());
        Item speaker2 = new Item(3L, "speaker", "JBL EON715", "789", "/src/main/resources/speakers", location2.getId());


        inventory.add(keyboard2);
        inventory.add(bassGuitar2);
        inventory.add(speaker2);



        //when
        LocationList locationHolder = new LocationList();
        locationHolder.setLocationList(location);
        locationHolder.setLocationList(location2);

        //Then

        Assertions.assertEquals(2, locationHolder.getLocationList().size());
        Assertions.assertEquals("Peniel Assembly", locationHolder.getLocationList().get(1).getName());
    }





}
