package com.spamblocker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spamblocker.dto.SpamRuleDto;

@Mapper
public interface SpamRuleMapper {
	
    @Select("SELECT * FROM spam_rule ORDER BY id DESC")
    List<SpamRuleDto> getAllRules();
    
    @Select("SELECT * FROM spam_rule WHERE match_type = #{matchType} ORDER BY id DESC")
    List<SpamRuleDto> getRulesByType(String matchType);
    
    @Insert("INSERT INTO spam_rule (phone_number, match_type, memo) VALUES (#{phoneNumber}, #{matchType}, #{memo})")
    void insertRule(SpamRuleDto dto);
    
    @Delete("DELETE FROM spam_rule WHERE id = #{id}")
    void deleteRule(Long id);
    
    @Update("UPDATE spam_rule SET phone_number = #{phoneNumber}, match_type = #{matchType}, memo = #{memo} WHERE id = #{id}")
    void updateRule(SpamRuleDto dto);
}
