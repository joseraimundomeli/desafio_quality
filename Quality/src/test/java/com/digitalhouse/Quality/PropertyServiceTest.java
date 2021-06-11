package com.digitalhouse.Quality;

import com.digitalhouse.Quality.dtos.PropertyDTO;
import com.digitalhouse.Quality.services.PropertyServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    private PropertyDTO propertyDTO = new PropertyDTO();
    private PropertyServiceImpl propertyServiceMock = mock(PropertyServiceImpl.class);

    @Test
    void getTotalSquareMetersTest(){
        //arrange
        when(propertyDTO.getRoons()).thenReturn(null);

        //act
        propertyServiceMock.getTotalSquareMeters(propertyDTO);

//        verify(propertyDTO, atLeastOnce());
//        assertEquals(0.0, propertyServiceMock.get);
//        EasyMock.expect(propertyServiceMock.getTotalSquareMeters(propertyDTO).getSize()).andReturn(10.0);
    }

    @Test
    void getDistrictTest(){

    }

    @Test
    void getBiggestRoomTest(){

    }

    @Test
    void getsRoomSquareMetersTest(){

    }

}
