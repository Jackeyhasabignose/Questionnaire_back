package com.example.Questionnaire_back.repository;

import com.example.Questionnaire_back.entity.Options;
import com.example.Questionnaire_back.entity.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OptionDao extends JpaRepository<Options, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `options` (question_id, questionnaire_id, option_text) VALUES (:questionId, :questionnaireId, :optionText)",
            nativeQuery = true)
    void insertOption(@Param("questionId") Integer questionId, @Param("questionnaireId") Integer questionnaireId, @Param("optionText") String optionText);

    
    @Query(value = "SELECT question_id FROM question ORDER BY question_id DESC LIMIT 1", nativeQuery = true)
    Integer getLastInsertedQuestionId();
    
    @Query("SELECT q FROM Question q WHERE q.questionId = :questionId")
    Question findByQuestionId(@Param("questionId") Integer questionId);

}
