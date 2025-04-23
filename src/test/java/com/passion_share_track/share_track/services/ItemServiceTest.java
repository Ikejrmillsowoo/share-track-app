//package com.passion_share_track.share_track.services;
//
//import com.passion_share_track.share_track.controllers.ItemController;
//import com.passion_share_track.share_track.models.Item;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.BDDMockito;
//import org.mockito.Mock;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(ItemService.class)
//public class ItemServiceTest {
//    @Mock
//    private ItemService service;
//
//    private ItemController controller;
//
//    @BeforeEach
//    public void setup(){
//        this.controller = new ItemController(service);
//    }
//
//    @Test
//    public void createTest() {
//        //Given
//        HttpStatus expected = HttpStatus.CREATED;
//        Item expectedItem = new Item(null, null, null, null, null, null);
//        BDDMockito
//                .given(service.create(expectedItem))
//                .willReturn(expectedItem);
//
//
//        //When
//        ResponseEntity<Item> response = controller.create(expectedItem);
//        HttpStatusCode actual = response.getStatusCode();
//        Item actualItem  = response.getBody();
//
//        //Then
//        Assertions.assertEquals(expected, actual);
//        Assertions.assertEquals(expectedItem, actualItem);
////        Long id = 1L;
////        String type = "Keyboard";
////        String model = "Yamaha MODX-8";
////        String barCodeNumber = "123-456";
////        String imageUrl = "/src/main/resources/keys";
////        Long locationId = 2L;
////
////        Item item = new Item(id, type, model, barCodeNumber, imageUrl, locationId);
////
////        //when
////        Long actualId = item.getId();
////
////        //Then
////        Assertions.assertEquals(1L, actualId);
////        Assertions.asser;
//    }
//}
