package com.valtech.training.quizservice.vos;

import java.util.List;

import com.valtech.training.quizservice.entities.QuestionResult;
import com.valtech.training.quizservice.entities.Quiz;


public record QuestionResultVO(Long id,Long quizId,Long quesId,String userAnswer,boolean result) {

	public static QuestionResultVO from(QuestionResult qr) {
		return new QuestionResultVO(qr.getId(),qr.getQuiz().getId(), qr.getQuesId(), qr.getUserAnswer(),qr.isResult());
	}
	
	public QuestionResult to(Quiz q) {
		QuestionResult qr = new QuestionResult(quesId, userAnswer, result);
		qr.setQuiz(q);
		return qr;
	}
}
