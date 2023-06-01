package com.example.onlinestore.controller;

import com.example.onlinestore.dto.request.product.ComputerRequestDto;
import com.example.onlinestore.dto.response.product.ComputerResponseDto;
import com.example.onlinestore.service.ComputerService;
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
@RequestMapping(path = "/computers")
public class ComputerController {
    private final ComputerService service;


    @PostMapping
    public ResponseEntity<ComputerResponseDto> createComputer(@RequestBody @Valid ComputerRequestDto requestDto) {
        log.info("ComputerController-createComputer. Recieved: {}", requestDto);

        ResponseEntity<ComputerResponseDto> response = new ResponseEntity<>(
                service.createComputer(requestDto), HttpStatus.CREATED
        );

        log.info("ComputerController-createComputer. Sending: {}", response);
        return response;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ComputerResponseDto> updateComputer(
            @PathVariable Long id, @RequestBody @Valid ComputerRequestDto requestDto
    ) {
        log.info("ComputerController-updateComputer. Recieved: {}; {}", id, requestDto);

        ResponseEntity<ComputerResponseDto> response = ResponseEntity.ok(service.updateComputer(id, requestDto));

        log.info("ComputerController-updateComputer. Sending: {}", response);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComputerResponseDto> getComputerById(@PathVariable Long id) {
        log.info("ComputerController-getComputerById. Recieved: {}", id);

        ResponseEntity<ComputerResponseDto> response = ResponseEntity.ok(service.getComputerById(id));

        log.info("ComputerController-getComputerById. Sending: {}", response);
        return response;
    }

    @GetMapping
    public ResponseEntity<List<ComputerResponseDto>> getAllComputers() {
        log.info("ComputerController-getAllComputers");

        ResponseEntity<List<ComputerResponseDto>> response = ResponseEntity.ok(service.getAllComputers());

        log.info("ComputerController-getAllComputers. Sending: {}", response);
        return response;
    }
}
