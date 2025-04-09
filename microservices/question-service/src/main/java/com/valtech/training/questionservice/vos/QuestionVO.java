package com.valtech.training.questionservice.vos;

import com.valtech.training.questionservice.entities.Question;

public record QuestionVO(long id,String questionText,String option1,String option2,String option3,String option4,String correctOption,String topic){

	public static QuestionVO from(Question q) {
		return new QuestionVO(q.getId(),q.getQuestionText(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getCorrectOption(),q.getTopic());
	}
	
	public Question to() {
		return new Question(questionText,option1,option2,option3,option4,correctOption,topic);
	}
}
