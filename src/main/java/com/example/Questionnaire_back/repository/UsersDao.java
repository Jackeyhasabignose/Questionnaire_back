package com.example.Questionnaire_back.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Questionnaire_back.entity.Options;
import com.example.Questionnaire_back.entity.Question;
import com.example.Questionnaire_back.entity.Questionnaire;
import com.example.Questionnaire_back.entity.Users;
@Repository
public interface UsersDao extends JpaRepository<Users, Integer> {
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO users (response_id, questionnaire_id, name, cellphone, email, age, finish_time, question_id, option_id, response_data) " +
	        "VALUES (:responseId, :questionnaireId, :name, :cellphone, :email, :age, :finishTime, :questionId, :optionId, :responseData)", nativeQuery = true)
	void insertUser(
	        @Param("responseId") Integer responseId,
	        @Param("questionnaireId") Integer questionnaireId,
	        @Param("name") String name,
	        @Param("cellphone") String cellphone,
	        @Param("email") String email,
	        @Param("age") Integer age,
	        @Param("finishTime") LocalDateTime finishTime,
	        @Param("questionId") Integer questionId,
	        @Param("optionId") Integer optionId,
	        @Param("responseData") List<String> responseData);
	
	@Query("SELECT u FROM Users u WHERE u.cellphone = :cellphone")
    Users findByCellphone(@Param("cellphone") String cellphone);


	
}
