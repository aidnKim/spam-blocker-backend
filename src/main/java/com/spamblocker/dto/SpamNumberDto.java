package com.spamblocker.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SpamNumberDto {
    private Long id;
    private String phoneNumber;
    private LocalDateTime createdAt;
}
