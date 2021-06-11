package com.digitalhouse.Quality.services;

import com.digitalhouse.Quality.dtos.*;

import java.util.List;

public interface PropertyService {
    PropertyResponseDTO getTotalSquareMeters(PropertyDTO propertyDTO);
    PropertyResponseDTO getPriceProperty(PropertyDTO propertyDTO);
    RoomDTO getBiggestRoom(PropertyDTO propertyDTO);
    List<RoomSquareDTO> getsRoomSquareMeters(PropertyDTO propertyDTO);
}
