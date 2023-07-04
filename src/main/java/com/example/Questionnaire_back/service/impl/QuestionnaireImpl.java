package com.example.Questionnaire_back.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Questionnaire_back.entity.Questionnaire;
import com.example.Questionnaire_back.repository.QuestionnaireDao;
import com.example.Questionnaire_back.service.ifs.QuestionnaireService;
import com.example.Questionnaire_back.vo.QuestionnaireRequest;
import com.example.Questionnaire_back.vo.QuestionnaireResponse;

@Service
public class QuestionnaireImpl implements QuestionnaireService {
    private final QuestionnaireDao questionnaireDao;

    @Autowired
    public QuestionnaireImpl(QuestionnaireDao questionnaireDao) {
        this.questionnaireDao = questionnaireDao;
    }

    @Override
    public QuestionnaireResponse AddQuestionnaire(QuestionnaireRequest request) {
        String questionnaireName = request.getQuestionnaireName();
        LocalDate startTime = request.getStartTime();
        LocalDate endTime = request.getEndTime();
        String description = request.getDescription();

        // Perform input validation
        if (questionnaireName == null || questionnaireName.isEmpty()) {
            return new QuestionnaireResponse("Questionnaire name is required.");
        }

        if (startTime == null || endTime == null) {
            return new QuestionnaireResponse("Start time and end time are required.");
        }

        if (startTime.isAfter(endTime)) {
            return new QuestionnaireResponse("Start time cannot be after end time.");
        }

        // Determine status based on current date
        LocalDate currentDate = LocalDate.now();
        String status;
        if (currentDate.isBefore(startTime)) {
            status = "未開放";
        } else if (currentDate.isEqual(startTime) || (currentDate.isAfter(startTime) && currentDate.isBefore(endTime))) {
            status = "開放";
        } else {
            status = "已關閉";
        }

        // Automatically add 7 days to the start time
        LocalDate newEndTime = startTime.plusDays(7);

        // Insert questionnaire
        questionnaireDao.insertQuestionnaire(questionnaireName, status, startTime, newEndTime, description);

        // Retrieve the last inserted questionnaire
        Questionnaire lastInsertedQuestionnaire = questionnaireDao.getLastInsertedQuestionnaire();
        if (lastInsertedQuestionnaire != null) {
            return new QuestionnaireResponse("Questionnaire added successfully.", lastInsertedQuestionnaire);
        } else {
            return new QuestionnaireResponse("Failed to retrieve the last inserted questionnaire.");
        }
    }







    @Override
    public QuestionnaireResponse FindAllQuestionnaire(QuestionnaireRequest request) {
        List<Questionnaire> questionnaires = questionnaireDao.findAllQuestionnairesWithNotNullId();
        if (!questionnaires.isEmpty()) {
            return new QuestionnaireResponse("Questionnaires found successfully.", questionnaires);
        } else {
            return new QuestionnaireResponse("No questionnaires found.");
        }
    }
    
    @Override
    public QuestionnaireResponse findAllQuestionnairesWithinDateRange(QuestionnaireRequest request) {
        LocalDate startTime = request.getStartTime();
        LocalDate endTime = request.getEndTime();

        List<Questionnaire> questionnaires = questionnaireDao.findAllQuestionnairesWithinDateRange(startTime, endTime);

        if (!questionnaires.isEmpty()) {
            return new QuestionnaireResponse("Questionnaires found successfully.", questionnaires);
        } else {
            return new QuestionnaireResponse("No questionnaires found.");
        }
    }






    @Override
    public QuestionnaireResponse DeleteQuestionnaire(QuestionnaireRequest request) {
        Integer questionnaireId = request.getQuestionnaireId();

        if (questionnaireId == null) {
            return new QuestionnaireResponse("Questionnaire ID is required for deletion.");
        }

        // Check if the questionnaire exists
        Optional<Questionnaire> existingQuestionnaireOptional = questionnaireDao.findById(questionnaireId);
        if (existingQuestionnaireOptional.isEmpty()) {
            return new QuestionnaireResponse("Questionnaire not found.");
        }

        // Delete the questionnaire
        questionnaireDao.deleteQuestionnaire(questionnaireId);

        return new QuestionnaireResponse("Questionnaire deleted successfully.");
    }



}