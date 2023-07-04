package com.example.Questionnaire_back.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Questionnaire_back.service.ifs.QuestionnaireService;
import com.example.Questionnaire_back.vo.QuestionnaireRequest;
import com.example.Questionnaire_back.vo.QuestionnaireResponse;
@CrossOrigin
@RestController
public class QuestionnaireController {
    @Autowired
    public QuestionnaireService questionnaireService;

    @PostMapping(value = "Add_questionnaire") 
    public QuestionnaireResponse AddQuestionnaire(@RequestBody QuestionnaireRequest request) {
        return questionnaireService.AddQuestionnaire(request);
    }
    
    @GetMapping(value = "Find_all_questionnaire") 
    public QuestionnaireResponse FindAllQuestionnaire() {
        return questionnaireService.FindAllQuestionnaire(null);
    }
    @PostMapping(value = "Delete_questionnaire") 
    public QuestionnaireResponse DeleteQuestionnaire(@RequestBody QuestionnaireRequest request) {
        return questionnaireService.DeleteQuestionnaire(request);
    }
    @PostMapping(value = "find_all_questionnaires_within_date_range") 
    public QuestionnaireResponse findAllQuestionnairesWithinDateRange(@RequestBody QuestionnaireRequest request) {
        return questionnaireService.findAllQuestionnairesWithinDateRange(request);
    }
}

