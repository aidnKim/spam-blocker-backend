package com.spamblocker.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SpamRuleDto {
    private Long id;
    private String phoneNumber;    // EXACT: 전체번호, PREFIX: 접두사
    private String matchType;      // "EXACT" 또는 "PREFIX"
    private String memo;
    private LocalDateTime createdAt;
}
