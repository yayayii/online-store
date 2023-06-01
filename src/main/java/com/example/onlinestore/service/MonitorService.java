package com.example.onlinestore.service;

import com.example.onlinestore.dto.request.product.MonitorRequestDto;
import com.example.onlinestore.dto.response.product.MonitorResponseDto;
import com.example.onlinestore.entity.product.Monitor;
import com.example.onlinestore.mapper.MonitorMapper;
import com.example.onlinestore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
@Service
public class MonitorService {
    private final ProductRepository<Monitor> repository;


    @Transactional
    public MonitorResponseDto addMonitor(MonitorRequestDto requestDto) {
        log.info("MonitorService-addMonitor. Recieved: {}", requestDto);

        Monitor monitor = MonitorMapper.toEntity(requestDto);
        MonitorResponseDto responseDto = MonitorMapper.toResponseDto(repository.save(monitor));

        log.info("MonitorService-addMonitor. Sending: {}", responseDto);
        return responseDto;
    }

    @Transactional
    public MonitorResponseDto updateMonitor(Long monitorId, MonitorRequestDto requestDto) {
        log.info("MonitorService-updateMonitor. Recieved: {}; {}",
                monitorId, requestDto);

        Monitor monitor = repository.findById(monitorId)
                .orElseThrow(() -> new NoSuchElementException("Computer id = " + monitorId + " doesn't exists"));
        monitor.setSeries(requestDto.getSeries());
        monitor.setCompany(requestDto.getCompany());
        monitor.setPrice(requestDto.getPrice());
        monitor.setAmount(requestDto.getAmount());
        monitor.setScreenSize(requestDto.getScreenSize());
        MonitorResponseDto responseDto = MonitorMapper.toResponseDto(monitor);

        log.info("MonitorService-updateMonitor. Sending: {}", responseDto);
        return responseDto;
    }

    public MonitorResponseDto getMonitorById(Long monitorId) {
        log.info("MonitorService-getMonitorById. Recieved: {}", monitorId);

        Monitor monitor = repository.findById(monitorId)
                .orElseThrow(() -> new NoSuchElementException("Monitor id = " + monitorId + " doesn't exists"));
        MonitorResponseDto responseDto = MonitorMapper.toResponseDto(monitor);

        log.info("MonitorService-getMonitorById. Sending: {}", responseDto);
        return responseDto;
    }

    public List<MonitorResponseDto> getAllMonitors() {
        log.info("MonitorService-getAllMonitors");

        List<MonitorResponseDto> computers = repository.findAll().stream()
                .map(MonitorMapper::toResponseDto).collect(Collectors.toList());

        log.info("MonitorService-getAllMonitors. Sending: {}", computers);
        return computers;
    }
}
