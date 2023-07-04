package com.example.Questionnaire_back.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Questionnaire_back.entity.Questionnaire;

@Repository
public interface QuestionnaireDao extends JpaRepository<Questionnaire, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO questionnaire (questionnaire_name, status, start_time, end_time, description) "
            + "VALUES (:questionnaireName, :status, :startTime, :endTime, :description)",
            nativeQuery = true)
    void insertQuestionnaire(@Param("questionnaireName") String questionnaireName,
                             @Param("status") String status,
                             @Param("startTime") LocalDate startTime,
                             @Param("endTime") LocalDate endTime,
                             @Param("description") String description);
    @Query(value = "SELECT * FROM questionnaire WHERE questionnaire_id = (SELECT MAX(questionnaire_id) FROM questionnaire)",
            nativeQuery = true)
    Questionnaire getLastInsertedQuestionnaire();
    @Query(value = "SELECT questionnaire_id FROM questionnaire ORDER BY questionnaire_id DESC LIMIT 1", nativeQuery = true)
    Integer getLastInsertedQuestionnaireId();
    
    @Query(value = "SELECT * FROM questionnaire WHERE questionnaire_id IS NOT NULL", nativeQuery = true)
    List<Questionnaire> findAllQuestionnairesWithNotNullId();
    
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM questionnaire WHERE questionnaire_id = :questionnaireId", nativeQuery = true)
    void deleteQuestionnaire(@Param("questionnaireId") Integer questionnaireId);
    
    @Query(value = "SELECT * FROM questionnaire WHERE questionnaire_id = :questionnaireId", nativeQuery = true)
    Questionnaire findByQuestionnaireId(@Param("questionnaireId") Integer questionnaireId);
    
    @Query(value = "SELECT COUNT(*) FROM question WHERE questionnaire_id = :questionnaireId",
            nativeQuery = true)
    Integer getQuestionCountByQuestionnaireId(@Param("questionnaireId") Integer questionnaireId);
    
    @Query(value = "SELECT * FROM questionnaire WHERE start_time >= :startTime AND end_time <= :endTime", nativeQuery = true)
    List<Questionnaire> findAllQuestionnairesWithinDateRange(@Param("startTime") LocalDate startTime, @Param("endTime") LocalDate endTime);


}