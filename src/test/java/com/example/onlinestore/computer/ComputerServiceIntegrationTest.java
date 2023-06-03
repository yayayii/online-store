package com.example.onlinestore.computer;

import com.example.onlinestore.dto.request.product.ComputerRequestDto;
import com.example.onlinestore.dto.response.product.ComputerResponseDto;
import com.example.onlinestore.entity.product.enum_.FormFactor;
import com.example.onlinestore.service.ComputerService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Transactional
@AllArgsConstructor(onConstructor_ = @Autowired)
@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:name",
        "spring.datasource.username=test",
        "spring.datasource.password=test",
        "server.port=8081"
})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComputerServiceIntegrationTest {
    private final ComputerService computerService;

    private static ComputerRequestDto[] requestDtos;
    private static ComputerResponseDto[] responseDtos;


    @BeforeAll
    public static void beforeAll() {
        requestDtos = new ComputerRequestDto[]{
                new ComputerRequestDto(
                        1L, "series", "company", 1.0, 0, FormFactor.DESKTOP
                ),
                new ComputerRequestDto(
                        1L, "series2", "company", 1.0, 0, FormFactor.DESKTOP
                ),
                new ComputerRequestDto(
                        3L, "series3", "company", 1.0, 0, FormFactor.DESKTOP
                )
        };
        responseDtos = new ComputerResponseDto[]{
                new ComputerResponseDto(
                        1L, "series", "company", 1.0, 0, FormFactor.DESKTOP
                ),
                new ComputerResponseDto(
                        1L, "series2", "company", 1.0, 0, FormFactor.DESKTOP
                ),
                new ComputerResponseDto(
                        2L, "series2", "company", 1.0, 0, FormFactor.DESKTOP
                ),
        };
    }


    @Test
    public void testCreateComputer() {
        //проверка возвращаемого объекта при успешном создании компьютера
        assertEquals(responseDtos[0], computerService.createComputer(requestDtos[0]));

        //проверка работы ограничения UNIQUE для поля series в таблице
        assertThrows(DataIntegrityViolationException.class, () -> computerService.createComputer(requestDtos[0]));
    }

    @Test
    public void testUpdateComputer() {
        //проверка возвращаемого объекта при успешном обновлении компьютера
        computerService.createComputer(requestDtos[0]);
        assertEquals(responseDtos[1], computerService.updateComputer(requestDtos[1]));

        //проверка выбрасывания исключения при неправильно указанном id
        assertThrows(NoSuchElementException.class, () -> computerService.updateComputer(requestDtos[2]));
    }

    @Test
    public void testGetComputerById() {
        //проверка возвращаемого объекта
        computerService.createComputer(requestDtos[0]);
        assertEquals(responseDtos[0], computerService.getComputerById(1L));

        //проверка выбрасывания исключения при неправильно указанном id
        assertThrows(NoSuchElementException.class, () -> computerService.getComputerById(2L));
    }

    @Test
    public void testGetAllComputers() {
        //проверка возвращаемого объекта
        computerService.createComputer(requestDtos[0]);
        computerService.createComputer(requestDtos[1]);
        assertEquals(List.of(responseDtos[0], responseDtos[2]), computerService.getAllComputers());
    }
}
