package com.valtech.training.questionservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.valtech.training.questionservice.entities.Question;
import com.valtech.training.questionservice.vos.QuestionVO;

public interface QuestionRepo extends JpaRepository<Question, Long>{

	@Query(value = "SELECT * FROM question WHERE topic = :topic order by random() LIMIT :limit",nativeQuery = true)
	public List<Question> findRandomQuestionsByTopic(@Param("topic") String topic,@Param("limit") int limit);
	
	public List<Question> findAllByTopic(String topic);
	
//	public List<Question> findRandomQuestionsByTopic(String topic,int limit);
}
