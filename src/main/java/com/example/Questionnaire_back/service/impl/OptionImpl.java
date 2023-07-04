package com.example.Questionnaire_back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Questionnaire_back.entity.Options;
import com.example.Questionnaire_back.entity.Question;
import com.example.Questionnaire_back.entity.Questionnaire;
import com.example.Questionnaire_back.repository.OptionDao;
import com.example.Questionnaire_back.repository.QuestionDao;
import com.example.Questionnaire_back.repository.QuestionnaireDao;
import com.example.Questionnaire_back.service.ifs.OptionService;
import com.example.Questionnaire_back.vo.OptionRequest;
import com.example.Questionnaire_back.vo.OptionResponse;

@Service
public class OptionImpl implements OptionService{
	private final QuestionDao questionDao;
	private final QuestionnaireDao questionnaireDao;
	private final OptionDao optionDao;

	@Autowired
	public OptionImpl(QuestionDao questionDao, QuestionnaireDao questionnaireDao, OptionDao optionDao) {
	    this.questionDao = questionDao;
	    this.questionnaireDao = questionnaireDao;
	    this.optionDao = optionDao; // 将 qptionDao 改为 optionDao
	}
	
	@Override
	public OptionResponse AddOptions(OptionRequest request) {
	    // 从 request 获取选项的文字列表
	    List<String> optionTexts = request.getOptionText();

	    // 从 request 获取问卷和问题的 ID
	    Integer questionnaireId = request.getQuestionnaire().getQuestionnaireId();
	    Integer questionId = request.getQuestion().getQuestionId();

	    // 使用 findByQuestionnaireId 和 findByQuestionId 找到对应的 Questionnaire 和 Question
	    Questionnaire questionnaire = questionnaireDao.findByQuestionnaireId(questionnaireId);
	    Question question = questionDao.findByQuestionId(questionId);

	    // 检查找到的 Questionnaire 和 Question 是否存在
	    if (questionnaire == null || question == null) {
	        return new OptionResponse("Unable to add options. Invalid questionnaire or question ID.");
	    }

	    // 循环遍历选项的文字列表，为每个选项创建并保存 Option 对象
	    for (String optionText : optionTexts) {
	        Options option = new Options(optionText);
	        option.setQuestionnaire(questionnaire);
	        option.setQuestion(question);
	        optionDao.save(option);
	    }

	    return new OptionResponse("Options added successfully.");
	}


	


}
