package com.digitalhouse.Quality.unit;

import com.digitalhouse.Quality.controllers.PropertyController;
import com.digitalhouse.Quality.dtos.PropertyDTO;
import com.digitalhouse.Quality.dtos.RoomDTO;
import com.digitalhouse.Quality.services.PropertyServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTest {
    @Mock
    private PropertyServiceImpl propertyServiceMock;

    @InjectMocks
    private PropertyController propertyController;

    private static PropertyDTO propertyDTO = propertyDTO =  new PropertyDTO(
            "Casa teste",
            "Bairro A",
            Arrays.asList(
                    new RoomDTO("Sala",5.0,7.0),
                    new RoomDTO("Quarto visita",10.0,4.0),
                    new RoomDTO("Quarto Suite",5.0,5.0),
                    new RoomDTO("Cozinha",15.0,5.0)
            )
    );


    @Test
    public void getTotalAreaTest(){
        // arrange
        PropertyDTO propertyDTOTest = propertyDTO;

        // act
        propertyController.getTotalArea(propertyDTOTest);

        // assert
        verify(propertyServiceMock, atLeastOnce()).getTotalArea(propertyDTOTest);
    }

}
