package com.example.Questionnaire_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.example.Questionnaire_back.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO question (questionnaire_id, question_text, is_required, question_type) "
            + "VALUES (:questionnaireId, :questionText, :isRequired, :questionType)",
            nativeQuery = true)
    void  insertQuestion(@Param("questionnaireId") Integer questionnaireId,
            @Param("questionText") String questionText,
            @Param("isRequired") Boolean isRequired,
            @Param("questionType") String questionType);
    
    
    @Query("SELECT q FROM Question q WHERE q.questionnaire.questionnaireId = :questionnaireId AND q.questionText = :questionText")
    Question findByQuestionnaireIdAndQuestionText(@Param("questionnaireId") Integer questionnaireId, @Param("questionText") String questionText);

    @Query("SELECT q FROM Question q WHERE q.questionId = :questionId")
    Question findByQuestionId(@Param("questionId") Integer questionId);

	
	
	
	@Query(value = "SELECT question_id FROM question ORDER BY question_id DESC LIMIT 1", nativeQuery = true)
    Integer getLastInsertedQuestionId();
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM question WHERE question_id = :questionId", nativeQuery = true)
	void deleteQuestion(@Param("questionId") Integer questionId);




	@Query(value = "SELECT * FROM question WHERE questionnaire_id = :questionnaireId", nativeQuery = true)
	List<Question> findByQuestionnaireId(@Param("questionnaireId") Integer questionnaireId);



	@Query(value = "SELECT * FROM question WHERE questionnaire_id = :questionnaireId AND question_id = :questionId", nativeQuery = true)
	Question findByQuestionnaireIdAndQuestionId(@Param("questionnaireId") Integer questionnaireId, @Param("questionId") Integer questionId);


//	@Query("SELECT q FROM Question q WHERE q.questionId = :questionId")
//    Question findByQuestionId(@Param("questionId") Integer questionId);
	

   
}
