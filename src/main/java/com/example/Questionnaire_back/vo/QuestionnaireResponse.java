package com.example.Questionnaire_back.vo;

import java.util.ArrayList;
import java.util.List;

import com.example.Questionnaire_back.entity.Questionnaire;

public class QuestionnaireResponse {
    private String message;
    private List<Questionnaire> questionnaire;

    public QuestionnaireResponse(String message, Questionnaire questionnaire) {
        this.message = message;
        this.questionnaire = new ArrayList<>();
        this.questionnaire.add(questionnaire);
    }
    public QuestionnaireResponse(String message, List<Questionnaire> questionnaireList) {
        this.message = message;
        this.questionnaire = questionnaireList;
    }

    
    

    public QuestionnaireResponse(String message) {
        this.message = message;
    }

   

    
   

	public List<Questionnaire> getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(List<Questionnaire> questionnaire) {
		this.questionnaire = questionnaire;
	}

	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

   

   
}
