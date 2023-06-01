package com.example.onlinestore.controller;

import com.example.onlinestore.dto.request.product.HddRequestDto;
import com.example.onlinestore.dto.response.product.HddResponseDto;
import com.example.onlinestore.service.HddService;
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
@RequestMapping(path = "/hdds")
public class HddController {
    private final HddService service;


    @PostMapping
    public ResponseEntity<HddResponseDto> createHdd(@RequestBody @Validated(Create.class) HddRequestDto requestDto) {
        log.info("ComputerController-createHdd. Recieved: {}", requestDto);

        ResponseEntity<HddResponseDto> response = new ResponseEntity<>(
                service.createHdd(requestDto), HttpStatus.CREATED
        );

        log.info("ComputerController-createHdd. Sending: {}", response);
        return response;
    }

    @PatchMapping
    public ResponseEntity<HddResponseDto> updateHdd(
            @RequestBody @Validated(Update.class) HddRequestDto requestDto
    ) {
        log.info("ComputerController-updateHdd. Recieved: {}", requestDto);

        ResponseEntity<HddResponseDto> response = ResponseEntity.ok(service.updateHdd(requestDto));

        log.info("ComputerController-updateHdd. Sending: {}", response);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HddResponseDto> getHddById(@PathVariable Long id) {
        log.info("ComputerController-getHddById. Recieved: {}", id);

        ResponseEntity<HddResponseDto> response = ResponseEntity.ok(service.getHddById(id));

        log.info("ComputerController-getHddById. Sending: {}", response);
        return response;
    }

    @GetMapping
    public ResponseEntity<List<HddResponseDto>> getAllHdds() {
        log.info("ComputerController-getAllHdds");

        ResponseEntity<List<HddResponseDto>> response = ResponseEntity.ok(service.getAllHdds());

        log.info("ComputerController-getAllHdds. Sending: {}", response);
        return response;
    }
}
