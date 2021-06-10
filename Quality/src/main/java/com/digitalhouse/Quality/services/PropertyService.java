package com.digitalhouse.Quality.services;

import com.digitalhouse.Quality.models.Room;

public interface PropertyService {
    Double computerSizeProperty();
    Double computerPriceProperty();
    Room getMaxRoom();
    Double getsRoomSquareMeters();
}
