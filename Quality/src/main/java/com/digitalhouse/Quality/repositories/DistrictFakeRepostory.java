package com.digitalhouse.Quality.repositories;

import com.digitalhouse.Quality.models.District;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


@Repository
public class DistrictFakeRepostory {
    private static List<District> districtList = Arrays.asList(
            new District("Centro", 1.5),
            new District("Zona norte", 3.5),
            new District("Zona sull", 5.0),
            new District("Zona leste", 3.5),
            new District("Zona oeste", 1.5),
            new District("Viaduto", 0.5),
            new District("Periferia", 1.5)
    );

    public List<District> list(){
        return districtList;
    }
}
