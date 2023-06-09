package com.example.onlinestore.service;

import com.example.onlinestore.dto.request.product.ComputerRequestDto;
import com.example.onlinestore.dto.response.product.ComputerResponseDto;
import com.example.onlinestore.entity.product.Computer;
import com.example.onlinestore.mapper.ComputerMapper;
import com.example.onlinestore.repository.ComputerRepository;
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
public class ComputerService {
    private final ComputerRepository repository;


    @Transactional
    public ComputerResponseDto createComputer(ComputerRequestDto requestDto) {
        log.info("ComputerService-createComputer. Recieved: {}", requestDto);

        Computer computer = ComputerMapper.toEntity(requestDto);
        ComputerResponseDto responseDto = ComputerMapper.toResponseDto(repository.save(computer));

        log.info("ComputerService-createComputer. Sending: {}", responseDto);
        return responseDto;
    }

    @Transactional
    public ComputerResponseDto updateComputer(ComputerRequestDto requestDto) {
        log.info("ComputerService-updateComputer. Recieved: {}", requestDto);

        Computer computer = repository.findById(requestDto.getId())
                .orElseThrow(() -> new NoSuchElementException("Computer id = " + requestDto.getId() + " doesn't exist"));
        computer.setSeries(requestDto.getSeries());
        computer.setCompany(requestDto.getCompany());
        computer.setPrice(requestDto.getPrice());
        computer.setAmount(requestDto.getAmount());
        computer.setFormFactor(requestDto.getFormFactor());
        ComputerResponseDto responseDto = ComputerMapper.toResponseDto(computer);

        log.info("ComputerService-updateComputer. Sending: {}", responseDto);
        return responseDto;
    }

    public ComputerResponseDto getComputerById(Long id) {
        log.info("ComputerService-getComputerById. Recieved: {}", id);

        Computer computer = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Computer id = " + id + " doesn't exist"));
        ComputerResponseDto responseDto = ComputerMapper.toResponseDto(computer);

        log.info("ComputerService-getComputerById. Sending: {}", responseDto);
        return responseDto;
    }

    public List<ComputerResponseDto> getAllComputers() {
        log.info("ComputerService-getAllComputers");

        List<ComputerResponseDto> computers = repository.findAll().stream()
                .map(ComputerMapper::toResponseDto).collect(Collectors.toList());

        log.info("ComputerService-getAllComputers. Sending: {}", computers);
        return computers;
    }
}
