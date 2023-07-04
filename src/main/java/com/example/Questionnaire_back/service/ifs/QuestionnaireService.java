package com.example.Questionnaire_back.service.ifs;

import java.time.LocalDate;
import java.util.List;

import com.example.Questionnaire_back.entity.Questionnaire;
import com.example.Questionnaire_back.vo.QuestionnaireRequest;
import com.example.Questionnaire_back.vo.QuestionnaireResponse;

public interface QuestionnaireService {
	// 新增問卷
	public QuestionnaireResponse AddQuestionnaire(QuestionnaireRequest request);

	// 尋找所有問卷
	public QuestionnaireResponse FindAllQuestionnaire(QuestionnaireRequest request);

	// 刪掉問卷
	public QuestionnaireResponse DeleteQuestionnaire(QuestionnaireRequest request);
	
	public QuestionnaireResponse findAllQuestionnairesWithinDateRange(QuestionnaireRequest request);

}
