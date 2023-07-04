package com.example.Questionnaire_back.vo;

import java.util.List;

import com.example.Questionnaire_back.entity.Question;
import com.example.Questionnaire_back.entity.Questionnaire;

public class OptionRequest {
    private List<String> optionText;
    private Question question;
    private Questionnaire questionnaire;

    public List<String> getOptionText() {
        return optionText;
    }

    public void setOptionText(List<String> optionText) {
        this.optionText = optionText;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }
}
