package com.valtech.training.quizservice.vos;

import com.valtech.training.quizservice.entities.Quiz;

public record QuizVO(long id,String user,String topic){

	public static QuizVO from(Quiz q) {
		return new QuizVO(q.getId(),q.getUser(),q.getTopic());
	}
	
	public Quiz to() {
		return new Quiz(user,topic);
	}
}
