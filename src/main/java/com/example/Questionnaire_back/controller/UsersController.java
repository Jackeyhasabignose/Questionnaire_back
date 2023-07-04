package com.example.Questionnaire_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Questionnaire_back.service.ifs.UsersService;

import com.example.Questionnaire_back.vo.UsersRequest;
import com.example.Questionnaire_back.vo.UsersResponse;
@CrossOrigin
@RestController
public class UsersController {
	@Autowired
	public UsersService usersService;

	@PostMapping(value = "Add_imfo")
	public UsersResponse AddImfo(@RequestBody UsersRequest request) {
		return usersService.AddImfo(request);
	}

}
