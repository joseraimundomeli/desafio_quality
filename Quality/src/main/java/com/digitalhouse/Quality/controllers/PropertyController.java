package com.digitalhouse.Quality.controllers;

import com.digitalhouse.Quality.dtos.PropertyDTO;
import com.digitalhouse.Quality.services.PropertyService;
import com.digitalhouse.Quality.services.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class PropertyController {

    @Autowired
    private PropertyServiceImpl propertyService;

    @GetMapping("totalsm")
    ResponseEntity<?> getTotalSize(@Valid @RequestBody PropertyDTO property){
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getTotalSquareMeters(property));
    }

    @GetMapping("price")
    ResponseEntity<?> getPrice(@Valid @RequestBody PropertyDTO property){
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getPriceProperty(property));
    }


    @GetMapping("bigroom")
    ResponseEntity<?> getBiggestRoom(@Valid @RequestBody PropertyDTO property){
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getBiggestRoom(property));
    }


    @GetMapping("msroomslist")
    ResponseEntity<?> getSuareRoonsList(@Valid @RequestBody PropertyDTO property){
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getsRoomSquareMeters(property));
    }

    @GetMapping("/**")
    public String testServer(@RequestBody Object obj){
        return obj.toString();
    }
}
