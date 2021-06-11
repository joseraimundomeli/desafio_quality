package com.digitalhouse.Quality.services;


import com.digitalhouse.Quality.exceptions.DistrictNotFoundException;
import com.digitalhouse.Quality.models.District;
import com.digitalhouse.Quality.repositories.DistrictFakeRepostory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService{

    private final DistrictFakeRepostory districtRespository = new DistrictFakeRepostory();

    @Override
    public District verifyDestrictExist(String districtName) {
        Optional<District> district = this.districtRespository.list()
                .stream()
                .filter(d -> d.getName().equals(districtName))
                .findFirst();
        if (district.isEmpty()){
            throw new DistrictNotFoundException(districtName);
        }
        return district.get();
    }
}
