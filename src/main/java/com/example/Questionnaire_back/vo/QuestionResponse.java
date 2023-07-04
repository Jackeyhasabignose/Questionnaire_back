package com.example.Questionnaire_back.vo;

public class QuestionResponse {

	private String message;
	private String questionText;
	private Integer questionId;
	private Boolean isRequired;
	private String questionType;
	private Integer questionnaireId;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public Boolean getIsRequired() {
		return isRequired;
	}
	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public Integer getQuestionnaireId() {
		return questionnaireId;
	}
	public void setQuestionnaireId(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
	}
	public QuestionResponse(String message) {
		super();
		this.message = message;
	}
	public QuestionResponse(String message, Boolean isRequired, Integer questionnaireId) {
	    this.message = message;
	    this.isRequired = isRequired;
	    this.questionnaireId = questionnaireId;
	}
	
}
