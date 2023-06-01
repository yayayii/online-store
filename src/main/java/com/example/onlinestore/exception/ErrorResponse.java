package com.example.onlinestore.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {
    private String status;
    private String reason;
    private String message;
    private LocalDateTime timestamp;
}
