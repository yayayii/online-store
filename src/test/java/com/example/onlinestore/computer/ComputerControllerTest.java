package com.example.onlinestore.computer;

import com.example.onlinestore.controller.ComputerController;
import com.example.onlinestore.dto.request.product.ComputerRequestDto;
import com.example.onlinestore.dto.response.product.ComputerResponseDto;
import com.example.onlinestore.entity.product.enum_.FormFactor;
import com.example.onlinestore.service.ComputerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ComputerControllerTest {
    @Mock
    private ComputerService mockComputerService;
    @InjectMocks
    private ComputerController computerController;
    private static ObjectMapper objectMapper;
    private MockMvc mockMvc;

    private static final String API_PREFIX = "/computers";
    private static ComputerRequestDto requestDto;
    private static ComputerResponseDto responseDto;


    @BeforeAll
    public static void beforeAll() {
        objectMapper = new ObjectMapper();

        requestDto = new ComputerRequestDto(
                1L, "series", "company", 1.0, 0, FormFactor.DESKTOP
        );
        responseDto = new ComputerResponseDto(
                1L, "series", "company", 1.0, 0, FormFactor.DESKTOP
        );
    }

    @BeforeEach
    public void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(computerController).build();
    }


    @Test
    public void testCreateComputer() throws Exception {
        //проверка на срабатываление валидации полей при создании компьютера
        mockMvc.perform(post(API_PREFIX)
                        .content(objectMapper.writeValueAsString(new ComputerRequestDto()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        //проверка на возвращаемый статус-код и наличие json при успешном создании компьютера
        when(mockComputerService.createComputer(any()))
                .thenReturn(responseDto);
        mockMvc.perform(post(API_PREFIX)
                        .content(objectMapper.writeValueAsString(requestDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testUpdateComputer() throws Exception {
        //проверка на срабатываление валидации полей при обновлении компьютера
        mockMvc.perform(patch(API_PREFIX)
                        .content(objectMapper.writeValueAsString(new ComputerRequestDto()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        //проверка на возвращаемый статус-код и наличие json при успешном обновлении компьютера
        when(mockComputerService.updateComputer(any()))
                .thenReturn(responseDto);
        mockMvc.perform(patch(API_PREFIX)
                        .content(objectMapper.writeValueAsString(requestDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetComputerById() throws Exception {
        //проверка на возвращаемый статус-код и наличие json при успешном получении компьютера по id
        when(mockComputerService.getComputerById(any()))
                .thenReturn(responseDto);
        mockMvc.perform(get(API_PREFIX + "/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetAllComputers() throws Exception {
        //проверка на возвращаемый статус-код и наличие json при успешном получении всех компьютеров
        when(mockComputerService.getAllComputers())
                .thenReturn(List.of(responseDto));
        mockMvc.perform(get(API_PREFIX))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
