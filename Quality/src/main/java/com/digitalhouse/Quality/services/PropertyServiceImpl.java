package com.digitalhouse.Quality.services;

import com.digitalhouse.Quality.dtos.*;
import com.digitalhouse.Quality.models.District;
import com.digitalhouse.Quality.repositories.DistrictFakeRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    private DistrictFakeRepostory districtRepostory;

    @Override
    public PropertyResponseDTO getTotalSquareMeters(PropertyDTO propertyDTO) {
        Double squareMeters = propertyDTO.getRoons()
                .stream()
                .mapToDouble(x -> this.computerSquareMeters(x.getRoomLength(), x.getRoomWidth()))
                .sum();

        return new PropertyResponseDTO(propertyDTO.getPropName(), "Total Square Meters is " + squareMeters);
    }

    @Override
    public PropertyResponseDTO getPriceProperty(PropertyDTO propertyDTO) {
        Double totalPrice = propertyDTO.getRoons()
                .stream()
                .mapToDouble(x -> this.computerSquareMeters(x.getRoomLength(), x.getRoomWidth()))
                .sum();

        totalPrice = totalPrice * this.verifyDistrict(propertyDTO.getPropDistrict()).getPriceInfluece();

        return new PropertyResponseDTO(propertyDTO.getPropName(), "Total price is " + totalPrice);

    }

    @Override
    public RoomDTO getBiggestRoom(PropertyDTO propertyDTO) {
        RoomDTO room = propertyDTO.getRoons()
                .stream()
                .max(Comparator.comparing(
                        x -> computerSquareMeters(x.getRoomLength(), x.getRoomLength()))
                    )
                .get();
        return room;
    }

    @Override
    public List<RoomSquareDTO> getsRoomSquareMeters(PropertyDTO propertyDTO) {
        List<RoomSquareDTO> roomSquareDTO = propertyDTO.getRoons()
                .stream()
                .map(x ->
                        new RoomSquareDTO(
                            x.getRoomName(),
                            this.computerSquareMeters(x.getRoomLength(), x.getRoomWidth())
                        )
                )
                .collect(Collectors.toList());
        return roomSquareDTO;
    }

    private District verifyDistrict(String districtName){
        Optional<District> district = districtRepostory.list()
                .stream()
                .filter(d -> d.getName().equals(districtName))
                .findFirst();
        if (!district.isPresent()){
            System.out.println("Distrito não existe");
        }
        return district.get();
    }



    private Double computerSquareMeters(Double length, Double width){
        return length * width;
    }
}
