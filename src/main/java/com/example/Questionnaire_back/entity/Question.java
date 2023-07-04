package com.example.Questionnaire_back.entity;




import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.example.Questionnaire_back.constants.QuestionType;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer questionId;
    
    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaire;
    
    @Column(name = "question_text")
    private String questionText;
    
    @Column(name = "is_required")
    private Boolean isRequired;
    
    @Column(name = "question_type")
    private String  questionType;

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	

	public void setRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public Question(Questionnaire questionnaire, String questionText, boolean isRequired, String questionType) {
		super();
		this.questionnaire = questionnaire;
		this.questionText = questionText;
		this.isRequired = isRequired;
		this.questionType = questionType;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<String> getOptionTexts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean getIsRequired() {
	    return isRequired;
	}

	public Integer getQuestionnaireId() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
    
    // Getters and setters
    
}


	
	
