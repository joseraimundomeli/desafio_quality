package com.digitalhouse.Quality.controllers;

import com.digitalhouse.Quality.dtos.PropertyDTO;
import com.digitalhouse.Quality.dtos.PropertyResponseDTO;
import com.digitalhouse.Quality.dtos.RoomDTO;
import com.digitalhouse.Quality.exceptions.DistrictNotFoundException;
import com.digitalhouse.Quality.exceptions.ResourceNotFound;
import com.digitalhouse.Quality.exceptions.ValidationErroLog;
import com.digitalhouse.Quality.services.PropertyService;
import com.digitalhouse.Quality.services.PropertyServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validation;


@RestController
@RequestMapping("/")
public class PropertyController {

    @Autowired
    private PropertyServiceImpl propertyService;


    @GetMapping("proparea")
    public ResponseEntity<?> getTotalArea(@Valid @RequestBody PropertyDTO property){
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getTotalArea(property));
    }


    @GetMapping("price")
    public ResponseEntity<?> getPrice(@Valid @RequestBody PropertyDTO property){
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getPriceProperty(property));
    }

    @GetMapping("bigroom")
    public ResponseEntity<?> getBiggestRoom(@Valid @RequestBody PropertyDTO property){
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getBiggestRoom(property));
    }

    @GetMapping("roomsarealist")
    public ResponseEntity<?> getRoonsAreaList(@Valid @RequestBody PropertyDTO property){
        return ResponseEntity.status(HttpStatus.OK).body(propertyService.getRoomsArea(property));
    }


    @GetMapping("/**")
    public ResponseEntity<?> testServer(){
        throw new ResourceNotFound();
    }

}
