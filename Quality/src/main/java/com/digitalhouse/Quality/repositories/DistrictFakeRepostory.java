package com.digitalhouse.Quality.repositories;

import com.digitalhouse.Quality.models.District;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


@Repository
public class DistrictFakeRepostory {
    private static final List<District> districtList = Arrays.asList(
            new District("Bairro A", 1.5),
            new District("Bairro B", 3.5),
            new District("Bairro C", 5.0),
            new District("Bairro D", 3.5),
            new District("Bairro E", 1.5),
            new District("Bairro F", 0.5),
            new District("Bairro G", 1.5)
    );

    public List<District> list(){
        return districtList;
    }
}
