package com.example.Questionnaire_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Questionnaire_back.service.ifs.OptionService;
import com.example.Questionnaire_back.vo.OptionRequest;
import com.example.Questionnaire_back.vo.OptionResponse;



@CrossOrigin
@RestController
public class OptionController {
	@Autowired
	public OptionService optionService;
	
	@PostMapping(value = "Add_option")
	public OptionResponse AddQuestionnaire(@RequestBody OptionRequest request) {
		return optionService.AddOptions(request);
	}

}
