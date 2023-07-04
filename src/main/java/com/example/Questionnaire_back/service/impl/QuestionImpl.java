package com.example.Questionnaire_back.service.impl;

import com.example.Questionnaire_back.constants.QuestionType;
import com.example.Questionnaire_back.entity.Question;
import com.example.Questionnaire_back.entity.Questionnaire;
import com.example.Questionnaire_back.repository.OptionDao;
import com.example.Questionnaire_back.repository.QuestionDao;
import com.example.Questionnaire_back.repository.QuestionnaireDao;
import com.example.Questionnaire_back.service.ifs.QuestionService;
import com.example.Questionnaire_back.vo.QuestionRequest;
import com.example.Questionnaire_back.vo.QuestionResponse;
import com.example.Questionnaire_back.vo.QuestionnaireResponse;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuestionImpl implements QuestionService {
	private final QuestionDao questionDao;
	private final QuestionnaireDao questionnaireDao;
	private final OptionDao optionDao;

	@Autowired
	public QuestionImpl(QuestionDao questionDao, QuestionnaireDao questionnaireDao, OptionDao optionDao) {
	    this.questionDao = questionDao;
	    this.questionnaireDao = questionnaireDao;
	    this.optionDao = optionDao; // 将 qptionDao 改为 optionDao
	}


	@Override
	public QuestionResponse AddQuestion(QuestionRequest request) {
	    String questionText = request.getQuestionText();
	    Boolean isRequired = request.getIsRequired();
	    QuestionType questionType = request.getQuestionType();
	    

	    // Get the questionnaire ID from the request object
	    Integer questionnaireId = request.getQuestionnaire().getQuestionnaireId();

	    // Validate questionText
	    if (questionText == null || questionText.isEmpty()) {
	        return new QuestionResponse("Question text is required.");
	    }

	    // Validate isRequired
	    if (isRequired == null) {
	        return new QuestionResponse("isRequired value is required.");
	    }

	    // Validate questionType
	    if (questionType == null) {
	        return new QuestionResponse("Question type is required.");
	    }

	    // Find the corresponding Questionnaire using findByQuestionnaireId
	    Questionnaire questionnaire = questionnaireDao.findByQuestionnaireId(questionnaireId);

	    // Check if the found Questionnaire exists
	    if (questionnaire == null) {
	        return new QuestionResponse("Unable to add question. Invalid questionnaire ID.");
	    }

	    // Create a new question using the found Questionnaire and other data
	    questionDao.insertQuestion(questionnaireId, questionText, isRequired, questionType.name());

	    // Retrieve the last inserted question ID
	    Integer lastInsertedQuestionId = questionDao.getLastInsertedQuestionId();

	    // Find the inserted question using findByQuestionId
	    Question newQuestion = questionDao.findByQuestionId(lastInsertedQuestionId);

	    // Create a new QuestionResponse object with the question details
	    QuestionResponse response = new QuestionResponse("Question added successfully.");
	    response.setQuestionText(newQuestion.getQuestionText());
	    response.setQuestionId(newQuestion.getQuestionId());
	    response.setIsRequired(newQuestion.getIsRequired());
	    response.setQuestionType(newQuestion.getQuestionType());
	    response.setQuestionnaireId(newQuestion.getQuestionnaire().getQuestionnaireId());

	    return response;
	    
	}











	@Override
	public QuestionResponse DeleteQuestion(QuestionRequest request) {
	    Integer questionId = request.getQuestionId();

	    // Perform input validation
	    if (questionId == null) {
	        return new QuestionResponse("Question ID is required for deletion.");
	    }

	    // Delete the question
	    questionDao.deleteQuestion(questionId);

	    return new QuestionResponse("Question deleted successfully.");
	}

}