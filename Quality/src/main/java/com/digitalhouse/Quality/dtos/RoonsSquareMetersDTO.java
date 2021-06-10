package com.digitalhouse.Quality.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class RoonsSquareMetersDTO {
    private String propName;
    private List<RoomSquareDTO> roons;
}
