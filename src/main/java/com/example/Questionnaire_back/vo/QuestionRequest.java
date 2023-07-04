package com.example.Questionnaire_back.vo;

import java.util.List;

import com.example.Questionnaire_back.constants.QuestionType;
import com.example.Questionnaire_back.entity.Questionnaire;

public class QuestionRequest {
    private String questionText;
    private Boolean isRequired;
    private QuestionType questionType;
    private Questionnaire questionnaire;
    private List<String> optionText; // 使用 optionText 作为选项列表字段
    private Integer questionId;

    public QuestionRequest() {
        this.isRequired = false; // Set isRequired to default value
    }
    
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public List<String> getOptionText() {
        return optionText;
    }

    public void setOptionText(List<String> optionText) {
        this.optionText = optionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    // 其他属性的访问方法...
}
