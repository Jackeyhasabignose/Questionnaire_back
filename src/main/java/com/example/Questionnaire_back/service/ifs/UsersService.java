package com.example.Questionnaire_back.service.ifs;


import com.example.Questionnaire_back.vo.UsersRequest;
import com.example.Questionnaire_back.vo.UsersResponse;

public interface UsersService {
	// 新增問卷
	public UsersResponse AddImfo(UsersRequest request);

}
