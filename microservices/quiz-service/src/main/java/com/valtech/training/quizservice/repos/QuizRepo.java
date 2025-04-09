package com.valtech.training.quizservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.valtech.training.quizservice.entities.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long>{

	
}
