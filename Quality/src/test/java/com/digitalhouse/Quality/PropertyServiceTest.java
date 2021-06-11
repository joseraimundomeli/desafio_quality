package com.digitalhouse.Quality;

import com.digitalhouse.Quality.dtos.PropertyDTO;
import com.digitalhouse.Quality.dtos.RoomDTO;
import com.digitalhouse.Quality.models.District;
import com.digitalhouse.Quality.services.PropertyServiceImpl;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @InjectMocks
    private PropertyServiceImpl propertyServiceMock;

    private static PropertyDTO propertyDTO ;

    private static RoomDTO bigeestRoom;

    @BeforeAll
    static void init(){
        propertyDTO =  new PropertyDTO(
                "Casa teste",
                "Bairro A",
                Arrays.asList(
                        new RoomDTO("Sala",5.0,7.0),
                        new RoomDTO("Quarto visita",10.0,4.0),
                        new RoomDTO("Quarto Suite",5.0,5.0),
                        new RoomDTO("Cozinha",15.0,5.0)
                )
        );

        bigeestRoom = new RoomDTO("Cozinha",15.0,5.0);
    }


    @Test
    void getTotalAreaTest(){
        //act
        Double totalSize = this.propertyServiceMock.computerTotalArea(propertyDTO);
        // Assert
        assertEquals(totalSize, 175.0, "O valor do calculo da área da casa deve ser 180.0");
    }


    @Test
    void getBiggestRoomTest(){
        // arc
        RoomDTO roomDTOTest = this.propertyServiceMock.getBiggestRoom(propertyDTO);
        // Assert
        assertEquals(bigeestRoom.getRoomName(), roomDTOTest.getRoomName(),  "Maior sala encontrada!");
    }

    @Test
    void getsRoomAreaTest(){
        //arc
        Double roomAreaTest = this.propertyServiceMock
                .computerArea(
                        bigeestRoom.getRoomLength(),
                        bigeestRoom.getRoomWidth()
                );
        // Assert
        assertEquals(roomAreaTest, 75.0, "A área do quarto deve ser 75.0 M2");


    }

}
