package com.example.onlinestore.controller;

import com.example.onlinestore.dto.request.product.MonitorRequestDto;
import com.example.onlinestore.dto.response.product.MonitorResponseDto;
import com.example.onlinestore.service.MonitorService;
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
@RequestMapping(path = "/monitors")
public class MonitorController {
    private final MonitorService service;


    @PostMapping
    public ResponseEntity<MonitorResponseDto> createMonitor(@RequestBody @Validated(Create.class) MonitorRequestDto requestDto) {
        log.info("MonitorController-createMonitor. Recieved: {}", requestDto);

        ResponseEntity<MonitorResponseDto> response = new ResponseEntity<>(
                service.createMonitor(requestDto), HttpStatus.CREATED
        );

        log.info("MonitorController-createMonitor. Sending: {}", response);
        return response;
    }

    @PatchMapping
    public ResponseEntity<MonitorResponseDto> updateMonitor(
            @RequestBody @Validated(Update.class) MonitorRequestDto requestDto
    ) {
        log.info("MonitorController-updateMonitor. Recieved: {}", requestDto);

        ResponseEntity<MonitorResponseDto> response = ResponseEntity.ok(service.updateMonitor(requestDto));

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
