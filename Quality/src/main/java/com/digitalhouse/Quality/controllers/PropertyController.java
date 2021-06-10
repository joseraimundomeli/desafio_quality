package com.digitalhouse.Quality.controllers;

import com.digitalhouse.Quality.dtos.PropertyDTO;
import com.digitalhouse.Quality.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("totalsm")
    ResponseEntity<?> getTotalSize(@RequestBody PropertyDTO property){
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getTotalSquareMeters(property));
    }

    @GetMapping("price")
    ResponseEntity<?> getPrice(@RequestBody PropertyDTO property){
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getPriceProperty(property));
    }


    @GetMapping("bigroom")
    ResponseEntity<?> getBiggestRoom(@RequestBody PropertyDTO property){
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getBiggestRoom(property));
    }


    @GetMapping("msroomslist")
    ResponseEntity<?> getSuareRoonsList(@RequestBody PropertyDTO property){
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getsRoomSquareMeters(property));
    }

    @GetMapping("/**")
    public String testServer(@RequestBody Object obj){
        return obj.toString();
    }
}
