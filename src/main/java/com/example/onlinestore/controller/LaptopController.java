package com.example.onlinestore.controller;

import com.example.onlinestore.dto.request.product.LaptopRequestDto;
import com.example.onlinestore.dto.response.product.LaptopResponseDto;
import com.example.onlinestore.service.LaptopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(path = "/laptops")
public class LaptopController {
    private final LaptopService service;


    @PostMapping
    public ResponseEntity<LaptopResponseDto> createLaptop(@RequestBody @Valid LaptopRequestDto requestDto) {
        log.info("LaptopController-createLaptop. Recieved: {}", requestDto);

        ResponseEntity<LaptopResponseDto> response = new ResponseEntity<>(
                service.createLaptop(requestDto), HttpStatus.CREATED
        );

        log.info("LaptopController-createLaptop. Sending: {}", response);
        return response;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LaptopResponseDto> updateLaptop(
            @PathVariable Long id, @RequestBody @Valid LaptopRequestDto requestDto
    ) {
        log.info("LaptopController-updateLaptop. Recieved: {}; {}", id, requestDto);

        ResponseEntity<LaptopResponseDto> response = ResponseEntity.ok(service.updateLaptop(id, requestDto));

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
