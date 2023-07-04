package com.example.Questionnaire_back.vo;

import java.util.List;

public class UsersResponse {
	 private String message;
	 private List<String> responseData;
	 

	public UsersResponse(String message, List<String> responseData) {
		super();
		this.message = message;
		this.responseData = responseData;
	}

	public List<String> getResponseData() {
		return responseData;
	}

	public void setResponseData(List<String> responseData) {
		this.responseData = responseData;
	}

	public UsersResponse(String string) {
		// TODO Auto-generated constructor stub
	}

	public UsersResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	 
}
