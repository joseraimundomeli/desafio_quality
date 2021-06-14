package com.digitalhouse.Quality.unit;



import com.digitalhouse.Quality.exceptions.DistrictNotFoundException;
import com.digitalhouse.Quality.models.District;
import com.digitalhouse.Quality.services.DistrictServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DistrictRespositoryTest {

    @InjectMocks
    static DistrictServiceImpl districtServiceMock;

    private static String districtName;
    private static String districNameErrorCase;

    @BeforeAll
    static void init(){
        districtName = "Bairro A";
        districNameErrorCase = "Bairro Z";
    }

    @Test
    public void destrictExistNormalCaseTest(){
        District districtTest = this.districtServiceMock.verifyDestrictExist(districtName);
        Assertions.assertEquals(districtName, districtTest.getName(), "Bairro " + districtName + " não encontrado");
    }

    @Test
    public void districtExistExceptionCaseTest(){
        assertThrows(
                DistrictNotFoundException.class, () -> this.districtServiceMock.verifyDestrictExist(
                        districNameErrorCase),
                "Erro DistrictNotFound deve ser gerado!");

    }
}
