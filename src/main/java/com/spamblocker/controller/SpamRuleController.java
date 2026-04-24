package com.spamblocker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spamblocker.dto.SpamRuleDto;
import com.spamblocker.service.SpamRuleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SpamRuleController {

    private final SpamRuleService spamRuleService;

    // 전체 조회
    @GetMapping("/spam-rules")
    public List<SpamRuleDto> getAllRules() {
        return spamRuleService.getAllRules();
    }

    // 타입별 조회 (예: /api/spam-rules?type=PREFIX)
    @GetMapping(value = "/spam-rules", params = "type")
    public List<SpamRuleDto> getRulesByType(@RequestParam("type") String type) {
        return spamRuleService.getRulesByType(type);
    }

    // 등록
    @PostMapping("/spam-rules")
    public String addRule(@RequestBody SpamRuleDto dto) {
        spamRuleService.addRule(dto);
        return "등록 완료";
    }

    // 삭제
    @DeleteMapping("/spam-rules/{id}")
    public String deleteRule(@PathVariable Long id) {
        spamRuleService.deleteRule(id);
        return "삭제 완료";
    }
}
