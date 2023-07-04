package com.example.Questionnaire_back.service.ifs;

import com.example.Questionnaire_back.vo.OptionRequest;
import com.example.Questionnaire_back.vo.OptionResponse;


public interface OptionService {
	public OptionResponse AddOptions(OptionRequest request);

}
