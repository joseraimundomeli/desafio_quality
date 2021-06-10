package com.digitalhouse.Quality.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Room {
    private String roomName;
    private Double roomWidth;
    private Double roomLength;
}
