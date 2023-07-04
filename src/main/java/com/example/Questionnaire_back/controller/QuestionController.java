package com.example.Questionnaire_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Questionnaire_back.service.ifs.QuestionService;

import com.example.Questionnaire_back.vo.QuestionRequest;
import com.example.Questionnaire_back.vo.QuestionResponse;
import com.example.Questionnaire_back.vo.QuestionnaireResponse;
@CrossOrigin
@RestController
public class QuestionController {
	@Autowired
	public QuestionService questionService;

	@PostMapping(value = "Add_question")
	public QuestionResponse AddQuestionnaire(@RequestBody QuestionRequest request) {
		return questionService.AddQuestion(request);
	}
	@PostMapping(value = "Delete_question")
	public QuestionResponse DeleteQuestion(@RequestBody QuestionRequest request) {
		return questionService.DeleteQuestion(request);
	}

}
