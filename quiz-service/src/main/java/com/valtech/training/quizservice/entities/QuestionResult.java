package com.valtech.training.quizservice.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class QuestionResult {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "result_seq")
	@SequenceGenerator(name = "result_seq",sequenceName = "result_seq",allocationSize = 1)
	private long id;
	@ManyToOne
	@JoinColumn(name = "quiz_id",referencedColumnName = "id")
	private Quiz quiz;
	private Long quesId;
	private String userAnswer;
	private boolean result;
	
	public QuestionResult() {}

	public QuestionResult(Long quesId, String userAnswer, boolean result) {
		this.quesId = quesId;
		this.userAnswer = userAnswer;
		this.result = result;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}


	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Quiz getQuiz() {
		return quiz;
	}


	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Long getQuesId() {
		return quesId;
	}

	public void setQuesId(Long quesId) {
		this.quesId = quesId;
	}


	
}
