package com.example.Questionnaire_back.service.impl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Questionnaire_back.entity.Question;
import com.example.Questionnaire_back.entity.Questionnaire;
import com.example.Questionnaire_back.entity.Users;
import com.example.Questionnaire_back.repository.QuestionDao;
import com.example.Questionnaire_back.repository.QuestionnaireDao;
import com.example.Questionnaire_back.repository.UsersDao;
import com.example.Questionnaire_back.service.ifs.UsersService;
import com.example.Questionnaire_back.vo.UsersRequest;
import com.example.Questionnaire_back.vo.UsersResponse;

@Service
public class UsersImpl implements UsersService {
    private final UsersDao usersDao;
    private final QuestionnaireDao questionnaireDao;
    private final QuestionDao questionDao;
    
    @Autowired
    public UsersImpl(UsersDao usersDao, QuestionnaireDao questionnaireDao, QuestionDao questionDao) {
        this.usersDao = usersDao;
        this.questionnaireDao = questionnaireDao;
        this.questionDao = questionDao;
    }
    
    @Override
    public UsersResponse AddImfo(UsersRequest request) {
        try {
            if (request != null && request.getQuestionnaire() != null) {
                Users user = new Users();
                Questionnaire questionnaire = questionnaireDao.findByQuestionnaireId(request.getQuestionnaire().getQuestionnaireId());

                if (questionnaire != null) {
                    String cellphone = request.getCellphone();

                    // 檢查手機號碼是否以 09 開頭且長度為 10
                    if (cellphone.startsWith("09") && cellphone.length() == 10) {

                        // 檢查手機號碼是否已經存在於資料庫中
                        if (usersDao.findByCellphone(cellphone) == null) {
                            user.setQuestionnaire(questionnaire);
                            user.setName(request.getName());
                            user.setCellphone(cellphone);
                            user.setEmail(request.getEmail());
                            user.setAge(request.getAge());
                            user.setFinishTime(LocalDateTime.now());

                            // 处理學生的回答数据
                            String responseData = request.getResponseData();
                            List<String> responseDataList = Arrays.asList(responseData.split(";"));

                            // 存儲使用者資料到資料庫
                            user.setResponseData(responseData);
                            usersDao.save(user);

                            // 其他程式碼...

                            UsersResponse response = new UsersResponse();
                            response.setMessage("資料插入成功");
                            response.setResponseData(responseDataList);
                            return response;
                        } else {
                            UsersResponse response = new UsersResponse();
                            response.setMessage("手機號碼已經被使用");
                            return response;
                        }
                    } else {
                        UsersResponse response = new UsersResponse();
                        response.setMessage("手機號碼格式錯誤");
                        return response;
                    }
                } else {
                    // questionnaire 為空值的處理邏輯
                    UsersResponse response = new UsersResponse();
                    response.setMessage("問卷資料不完整");
                    return response;
                }
            } else {
                // request 或 request.getQuestionnaire() 為空值的處理邏輯
                UsersResponse response = new UsersResponse();
                response.setMessage("請提供有效的請求資料");
                return response;
            }
        } catch (Exception e) {
            e.printStackTrace();
            UsersResponse response = new UsersResponse();
            response.setMessage("資料插入失敗");
            return response;
        }
    }





}