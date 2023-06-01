package com.example.onlinestore.controller;

import com.example.onlinestore.dto.request.product.HddRequestDto;
import com.example.onlinestore.dto.response.product.HddResponseDto;
import com.example.onlinestore.service.HddService;
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
@RequestMapping(path = "/hdds")
public class HddController {
    private final HddService service;


    @PostMapping
    public ResponseEntity<HddResponseDto> createHdd(@RequestBody @Valid HddRequestDto requestDto) {
        log.info("ComputerController-createHdd. Recieved: {}", requestDto);

        ResponseEntity<HddResponseDto> response = new ResponseEntity<>(
                service.createHdd(requestDto), HttpStatus.CREATED
        );

        log.info("ComputerController-createHdd. Sending: {}", response);
        return response;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HddResponseDto> updateHdd(
            @PathVariable Long id, @RequestBody @Valid HddRequestDto requestDto
    ) {
        log.info("ComputerController-updateHdd. Recieved: {}; {}", id, requestDto);

        ResponseEntity<HddResponseDto> response = ResponseEntity.ok(service.updateHdd(id, requestDto));

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
