package com.example.Questionnaire_back.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questionnaire")
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionnaire_id")
    private Integer questionnaireId;
    
    @Column(name = "questionnaire_name")
    private String questionnaireName;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "start_time")
    private LocalDate startTime;
    
    @Column(name = "end_time")
    private LocalDate endTime;
    
    @Column(name = "description")
    private String description;
    
   
    
    

	

	public Integer getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getQuestionnaireName() {
		return questionnaireName;
	}

	public void setQuestionnaireName(String questionnaireName) {
		this.questionnaireName = questionnaireName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public LocalDate getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Questionnaire(String questionnaireName, String status, LocalDate startTime, LocalDate endTime,
			String description) {
		super();
		this.questionnaireName = questionnaireName;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
	}

	public Questionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    // Getters and setters
    
}
