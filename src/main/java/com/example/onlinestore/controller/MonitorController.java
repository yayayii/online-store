package com.example.onlinestore.controller;

import com.example.onlinestore.dto.request.product.MonitorRequestDto;
import com.example.onlinestore.dto.response.product.MonitorResponseDto;
import com.example.onlinestore.service.MonitorService;
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
@RequestMapping(path = "/monitors")
public class MonitorController {
    private final MonitorService service;


    @PostMapping
    public ResponseEntity<MonitorResponseDto> createMonitor(@RequestBody @Valid MonitorRequestDto requestDto) {
        log.info("MonitorController-createMonitor. Recieved: {}", requestDto);

        ResponseEntity<MonitorResponseDto> response = new ResponseEntity<>(
                service.createMonitor(requestDto), HttpStatus.CREATED
        );

        log.info("MonitorController-createMonitor. Sending: {}", response);
        return response;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MonitorResponseDto> updateMonitor(
            @PathVariable Long id, @RequestBody @Valid MonitorRequestDto requestDto
    ) {
        log.info("MonitorController-updateMonitor. Recieved: {}; {}", id, requestDto);

        ResponseEntity<MonitorResponseDto> response = ResponseEntity.ok(service.updateMonitor(id, requestDto));

        log.info("MonitorController-updateMonitor. Sending: {}", response);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonitorResponseDto> getMonitorById(@PathVariable Long id) {
        log.info("MonitorController-getMonitorById. Recieved: {}", id);

        ResponseEntity<MonitorResponseDto> response = ResponseEntity.ok(service.getMonitorById(id));

        log.info("MonitorController-getMonitorById. Sending: {}", response);
        return response;
    }

    @GetMapping
    public ResponseEntity<List<MonitorResponseDto>> getAllMonitors() {
        log.info("MonitorController-getAllMonitors");

        ResponseEntity<List<MonitorResponseDto>> response = ResponseEntity.ok(service.getAllMonitors());

        log.info("MonitorController-getAllMonitors. Sending: {}", response);
        return response;
    }
}
