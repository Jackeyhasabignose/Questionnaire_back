package com.example.Questionnaire_back.service.ifs;

import com.example.Questionnaire_back.vo.QuestionRequest;
import com.example.Questionnaire_back.vo.QuestionResponse;
import com.example.Questionnaire_back.vo.QuestionnaireResponse;

public interface QuestionService {
	// 新增問卷的問題
	public QuestionResponse AddQuestion(QuestionRequest request);
	
	// 新增問卷的問題
		public QuestionResponse DeleteQuestion(QuestionRequest request);

}
