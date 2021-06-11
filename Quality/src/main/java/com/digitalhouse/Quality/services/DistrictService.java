package com.digitalhouse.Quality.services;

import com.digitalhouse.Quality.models.District;
import com.digitalhouse.Quality.repositories.DistrictFakeRepostory;
import org.springframework.stereotype.Service;

@Service
public interface DistrictService {
    District verifyDestrictExist(String districtName);

}
