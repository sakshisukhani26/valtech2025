package com.valtech.training.quizservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.quizservice.entities.QuestionResult;
import com.valtech.training.quizservice.vos.QuestionResultVO;

public interface QuestionResultRepo extends JpaRepository<QuestionResult, Long>{

	List<QuestionResult> findAllQuestionResultsByQuizId(long id);
}
