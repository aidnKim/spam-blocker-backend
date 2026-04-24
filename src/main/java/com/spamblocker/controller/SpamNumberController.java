package com.spamblocker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spamblocker.dto.SpamNumberDto;
import com.spamblocker.mapper.SpamNumberMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SpamNumberController {
	
	private final SpamNumberMapper spamNumberMapper;
	
	@GetMapping("/spam-numbers")
	public List<SpamNumberDto> getSpamNumbers(){
		return spamNumberMapper.getAllSpamNumbers();
	}
}
