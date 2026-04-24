package com.spamblocker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spamblocker.dto.SpamNumberDto;

@Mapper
public interface SpamNumberMapper {
	
	@Select("SELECT * FROM spam_number ORDER BY id DESC")
	List<SpamNumberDto> getAllSpamNumbers();
}
