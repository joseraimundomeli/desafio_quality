package com.digitalhouse.Quality.services;

import com.digitalhouse.Quality.dtos.*;

import java.util.List;

public interface PropertyService {
    PropertyResponseDTO getTotalArea(PropertyDTO propertyDTO);
    PropertyResponseDTO getPriceProperty(PropertyDTO propertyDTO);
    RoomDTO getBiggestRoom(PropertyDTO propertyDTO);
    List<RoomSquareDTO> getRoomsArea(PropertyDTO propertyDTO);
}
