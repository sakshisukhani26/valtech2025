package com.valtech.training.resultservice.services;

public class ResultServiceImpl {
	
//	@Override
//	public QuizResult evaluateResult(String username,List<String[]> answers) {
//		int score = 0;
//		List<Question> questions = new ArrayList<>();
//		List<String> actualAnswers = new ArrayList<>();
//		
//		for(String[] result : answers) {
//			Long questionId = Long.valueOf(result[0]);
//			String actualAnswer = result[1];
//			
//			Question question = questionRepo.findById(questionId).orElse(null);
//			if(question == null) continue;
//			
//			if(question.getCorrectOption().equalsIgnoreCase(actualAnswer)) {
//				score++;
//			}
//			questions.add(question);
//			actualAnswers.add(actualAnswer);
//		}
//		return new QuizResult(username,score,questions,actualAnswers);
//	}
}
