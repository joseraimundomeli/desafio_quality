package com.digitalhouse.Quality.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Property {
    private String propName;
    private String propDistrict;
    private List<Room> roons;
}
