package com.digitalhouse.Quality.services;

import com.digitalhouse.Quality.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    private DistrictServiceImpl districtService;

    @Override
    public PropertyResponseDTO getTotalArea(PropertyDTO propertyDTO) {
        Double squareMeters = propertyDTO.getRoons()
                .stream()
                .mapToDouble(x -> this.computerArea(x.getRoomLength(), x.getRoomWidth()))
                .sum();

        return new PropertyResponseDTO(propertyDTO.getPropName(), "Total area: " + squareMeters);
    }

    @Override
    public PropertyResponseDTO getPriceProperty(PropertyDTO propertyDTO) {

        Double totalArea = this.computerTotalArea(propertyDTO);
        Double districtInfluence = this.districtService.verifyDestrictExist(propertyDTO.getPropDistrict()).getPriceInfluece();

        Double totalPrice = totalArea * districtInfluence;

        return new PropertyResponseDTO(propertyDTO.getPropName(), " Total área " + totalArea + " X district influence " + districtInfluence +  " = Total price: $ " + totalPrice);

    }

    @Override
    public RoomDTO getBiggestRoom(PropertyDTO propertyDTO) {
        RoomDTO room = propertyDTO.getRoons()
                .stream()
                .max(Comparator.comparing(
                        x -> computerArea( x.getRoomLength(), x.getRoomWidth()))
                    )
                .get();
        return room;
    }

    @Override
    public List<RoomSquareDTO> getRoomsArea(PropertyDTO propertyDTO) {
        List<RoomSquareDTO> roomSquareDTO = propertyDTO.getRoons()
                .stream()
                .map(x ->
                        new RoomSquareDTO(
                            x.getRoomName(),
                            this.computerArea(x.getRoomLength(), x.getRoomWidth())
                        )
                )
                .collect(Collectors.toList());
        return roomSquareDTO;
    }


    public Double computerTotalArea(PropertyDTO propertyDTO) {
        Double totalSize = propertyDTO.getRoons()
                .stream()
                .mapToDouble(x -> this.computerArea(x.getRoomLength(), x.getRoomWidth()))
                .sum();

        return totalSize;
    }


    public Double computerArea(Double length, Double width){
        return length * width;
    }
}
