package com.example.onlinestore.controller;

import com.example.onlinestore.dto.request.product.LaptopRequestDto;
import com.example.onlinestore.dto.response.product.LaptopResponseDto;
import com.example.onlinestore.service.LaptopService;
import com.example.onlinestore.util.marker.Create;
import com.example.onlinestore.util.marker.Update;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(path = "/laptops")
public class LaptopController {
    private final LaptopService service;


    @PostMapping
    public ResponseEntity<LaptopResponseDto> createLaptop(@RequestBody @Validated(Create.class) LaptopRequestDto requestDto) {
        log.info("LaptopController-createLaptop. Recieved: {}", requestDto);

        ResponseEntity<LaptopResponseDto> response = new ResponseEntity<>(
                service.createLaptop(requestDto), HttpStatus.CREATED
        );

        log.info("LaptopController-createLaptop. Sending: {}", response);
        return response;
    }

    @PatchMapping
    public ResponseEntity<LaptopResponseDto> updateLaptop(
            @RequestBody @Validated(Update.class) LaptopRequestDto requestDto
    ) {
        log.info("LaptopController-updateLaptop. Recieved: {}", requestDto);

        ResponseEntity<LaptopResponseDto> response = ResponseEntity.ok(service.updateLaptop(requestDto));

        log.info("LaptopController-updateLaptop. Sending: {}", response);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaptopResponseDto> getLaptopById(@PathVariable Long id) {
        log.info("LaptopController-getLaptopById. Recieved: {}", id);

        ResponseEntity<LaptopResponseDto> response = ResponseEntity.ok(service.getLaptopById(id));

        log.info("LaptopController-getLaptopById. Sending: {}", response);
        return response;
    }

    @GetMapping
    public ResponseEntity<List<LaptopResponseDto>> getAllLaptops() {
        log.info("LaptopController-getAllLaptops");

        ResponseEntity<List<LaptopResponseDto>> response = ResponseEntity.ok(service.getAllLaptops());

        log.info("LaptopController-getAllLaptops. Sending: {}", response);
        return response;
    }
}
