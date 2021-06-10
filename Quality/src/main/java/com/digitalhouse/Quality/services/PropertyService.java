package com.digitalhouse.Quality.services;

import com.digitalhouse.Quality.dtos.*;

public interface PropertyService {
    PropertySizeDTO getTotalSquareMeters(PropertyDTO propertyDTO);
    PropertyPriceDTO getPriceProperty(PropertyDTO propertyDTO);
    RoomDTO getBiggestRoom(PropertyDTO propertyDTO);
    RoonsSquareMetersDTO getsRoomSquareMeters(PropertyDTO propertyDTO);
}
