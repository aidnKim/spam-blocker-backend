package com.spamblocker.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.spamblocker.dto.SpamRuleDto;
import com.spamblocker.mapper.SpamRuleMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpamRuleService {

    private final SpamRuleMapper spamRuleMapper;

    // 전체 룰 조회
    public List<SpamRuleDto> getAllRules() {
        return spamRuleMapper.getAllRules();
    }

    // 타입별 조회 (EXACT 또는 PREFIX)
    public List<SpamRuleDto> getRulesByType(String matchType) {
        return spamRuleMapper.getRulesByType(matchType);
    }

    // 룰 등록
    public void addRule(SpamRuleDto dto) {
        // matchType 유효성 검사
        if (!"EXACT".equals(dto.getMatchType()) && !"PREFIX".equals(dto.getMatchType())) {
            throw new IllegalArgumentException("matchType은 'EXACT' 또는 'PREFIX'만 가능합니다.");
        }
        spamRuleMapper.insertRule(dto);
    }

    // 룰 삭제
    public void deleteRule(Long id) {
        spamRuleMapper.deleteRule(id);
    }
    
    // 룰 업데이트 
    public void updateRule(SpamRuleDto dto) {
        if (!"EXACT".equals(dto.getMatchType()) && !"PREFIX".equals(dto.getMatchType())) {
            throw new IllegalArgumentException("matchType은 'EXACT' 또는 'PREFIX'만 가능합니다.");
        }
        spamRuleMapper.updateRule(dto);
    }
}
