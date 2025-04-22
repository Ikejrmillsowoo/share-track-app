package com.passion_share_track.share_track.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LocationTest {
    @Test
    public void createLocationTest() {
        //Given

        Long id = 1L;
        String name = "Delaware Central";
        String addressStreet = "123 Egg McMuffin Lane";
        String addressCity = "Bear";
        String addressState = "Delaware";
        String addressZip = "19702";
        List<Item> inventory = new ArrayList<>();

        Location location = new Location( id, name, addressStreet, addressCity, addressState, addressZip, inventory);
        Item keyboard = new Item(1L, "keyboard", "MODX-8", "123", "/src/main/resources/keys", location);
        Item bassGuitar = new Item(2L, "bass", "6 String Scepter Euro4XL", "321", "/src/main/resources/bass", location);
        Item speakers = new Item(3L, "speaker", "JBL EON715", "789", "/src/main/resources/speakers", location);


        inventory.add(keyboard);
        inventory.add(bassGuitar);
        inventory.add(speakers);

        //When
        Long actualId =  location.getId();
        String actualName = location.getName();
        String actualAddressStreet = location.getAddressStreet();
        String actualAddressCity = location.getAddressCity();
        String actualAddressState = location.getAddressState();
        String actualAddressZip = location.getAddressZip();

        //Then
        Assertions.assertEquals(id, actualId);
        Assertions.assertEquals(name, actualName);
        Assertions.assertEquals(addressStreet, actualAddressStreet);
        Assertions.assertEquals(addressCity, actualAddressCity);
        Assertions.assertEquals(addressState, actualAddressState);
        Assertions.assertEquals(addressZip, actualAddressZip);
    }

    @Test
    public void inventoryTest() {
        Long id = 1L;
        String name = "Delaware Central";
        String addressStreet = "123 Egg McMuffin Lane";
        String addressCity = "Bear";
        String addressState = "Delaware";
        String addressZip = "19702";
        List<Item> inventory = new ArrayList<>();
        Location location = new Location( id, name, addressStreet, addressCity, addressState, addressZip, inventory);
        Item keyboard = new Item(1L, "keyboard", "MODX-8", "123", "/src/main/resources/keys", location);
        Item bassGuitar = new Item(2L, "bass", "6 String Scepter Euro4XL", "321", "/src/main/resources/bass", location);
        Item speaker = new Item(3L, "speaker", "JBL EON715", "789", "/src/main/resources/speakers", location);


        inventory.add(keyboard);
        inventory.add(bassGuitar);
        inventory.add(speaker);

        //when
        List<Item> actualInventory = location.getInventory();
        Item actualKeyboard = location.getInventory().get(0);
        Item actualBassGuitar = location.getInventory().get(1);
        Item actualSpeaker = location.getInventory().get(2);
        String actualSpeakerModel = location.getInventory().get(2).getModel();
        String actualBassGuitarModel = location.getInventory().get(1).getModel();
        String actualKeyboardModel = location.getInventory().get(0).getModel();

        //Then
        Assertions.assertEquals(inventory, actualInventory);
        Assertions.assertEquals(keyboard, actualKeyboard);
        Assertions.assertEquals(bassGuitar, actualBassGuitar);
        Assertions.assertEquals(speaker, actualSpeaker);
        Assertions.assertEquals("JBL EON715", actualSpeakerModel);
        Assertions.assertEquals("6 String Scepter Euro4XL", actualBassGuitarModel);
        Assertions.assertEquals("MODX-8", actualKeyboardModel);
    }

    @Test
    public void locationTest() {
        Long id = 1L;
        String name = "Delaware Central";
        String addressStreet = "123 Egg McMuffin Lane";
        String addressCity = "Bear";
        String addressState = "Delaware";
        String addressZip = "19702";
        List<Item> inventory = new ArrayList<>();
        Location location = new Location( id, name, addressStreet, addressCity, addressState, addressZip, inventory);

        Item keyboard = new Item(1L, "keyboard", "MODX-8", "123", "/src/main/resources/keys", location);
        Item bassGuitar = new Item(2L, "bass", "6 String Scepter Euro4XL", "321", "/src/main/resources/bass", location);
        Item speaker = new Item(3L, "speaker", "JBL EON715", "789", "/src/main/resources/speakers", location);

        inventory.add(keyboard);
        inventory.add(bassGuitar);
        inventory.add(speaker);

        Long id2 = 2L;
        String name2 = "Delaware Central";
        String addressStreet2 = "123 Egg McMuffin Lane";
        String addressCity2 = "Bear";
        String addressState2 = "Delaware";
        String addressZip2 = "19702";
        List<Item> inventory2 = new ArrayList<>();
        Location location2 = new Location( id2, name2, addressStreet2, addressCity2, addressState2, addressZip2, inventory2);
        Item keyboard2 = new Item(1L, "keyboard", "MODX-8", "123", "/src/main/resources/keys", location);
        Item bassGuitar2 = new Item(2L, "bass", "6 String Scepter Euro4XL", "321", "/src/main/resources/bass", location);
        Item speaker2 = new Item(3L, "speaker", "JBL EON715", "789", "/src/main/resources/speakers", location);


        inventory.add(keyboard2);
        inventory.add(bassGuitar2);
        inventory.add(speaker2);

        //when
        List<Item> actualInventory = location.getInventory();
        Item actualKeyboard = location.getInventory().get(0);
        Item actualBassGuitar = location.getInventory().get(1);
        Item actualSpeaker = location.getInventory().get(2);
        String actualSpeakerModel = location.getInventory().get(2).getModel();
        String actualBassGuitarModel = location.getInventory().get(1).getModel();
        String actualKeyboardModel = location.getInventory().get(0).getModel();

        //Then
        Assertions.assertEquals(inventory, actualInventory);
        Assertions.assertEquals(keyboard, actualKeyboard);
        Assertions.assertEquals(bassGuitar, actualBassGuitar);
        Assertions.assertEquals(speaker, actualSpeaker);
        Assertions.assertEquals("JBL EON715", actualSpeakerModel);
        Assertions.assertEquals("6 String Scepter Euro4XL", actualBassGuitarModel);
        Assertions.assertEquals("MODX-8", actualKeyboardModel);

    }
}
