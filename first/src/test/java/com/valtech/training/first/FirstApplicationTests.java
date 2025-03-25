package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.services.BookService;
import com.valtech.training.first.services.QuestionService;

@SpringBootTest
class FirstApplicationTests {

	@Autowired
	private Arithmetic arithmetic;
	
	@Autowired
	private SimpleInterest simpleInterest;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private BookService bookservice;
	
	@Test
	void testArithmetic() {
		assertEquals(10, arithmetic.add(4, 6));
		assertEquals(200, simpleInterest.compute(200, 5, 20));
	}
	
	
	@Test
	void questionService() {
//		initData();
		assertEquals(6, questionService.countByTopic("GK"));
		assertEquals(6, questionService.findAllByTopic("Java").size());
		assertEquals(2, questionService.countByTopicAndQuestionTextContaining("Java","Exception"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContaining("Java","Interface"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContaining("Java","Interface"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContainingIgnoreCase("Java","interface"));
		assertEquals(5, questionService.findAllByTopic(("GK"),0,5).size());
		assertEquals(1, questionService.findAllByTopic(("GK"),1,5).size());
	}
	
	
	@BeforeEach
	void initData() {
		System.out.println("Question Service class name : "+questionService.getClass().getName());
		long count = questionService.count();
		if(count!=0) return;
		Question q = questionService.saveQuestion(new Question("What is the color of Sky?","Red","Green","Blue","white","Blue","GK"));
		questionService.saveQuestion(new Question("What is the color of Mars?","Red","Green","Blue","white","Red","GK"));
		questionService.saveQuestion(new Question("What is the color of Moon?","Red","Green","Blue","white","white","GK"));
		questionService.saveQuestion(new Question("What is the color of Jupiter?","Red","Green","Blue","white","Yellow","GK"));
		questionService.saveQuestion(new Question("What is the color of Saturn?","Red","Green","Blue","white","Blue","GK"));
		questionService.saveQuestion(new Question("What is the color of Venus?","Red","Green","Blue","white","white","GK"));
		questionService.saveQuestion(new Question("What is the super class of Exceptions?","Object","Exception","Throwable","Error","Throwable","Java"));
		questionService.saveQuestion(new Question("What is the class is used to create dynamic string?","string","dynamic string","String builder","builder","String builder","Java"));
		questionService.saveQuestion(new Question("How many methods are there in Marker Interface?","None","One","Two","Many","None","Java"));
		questionService.saveQuestion(new Question("How many methods are there in Functional Interface?","None","One","Two","Many","One","Java"));
		questionService.saveQuestion(new Question("Can an Interface have private methods?","Yes","No","Maybe","No methods can be there in an interface","Yes","Java"));
		questionService.saveQuestion(new Question("Which subclass of Exception is not checked by the compiler?","Exception","Error","RuntimeException","None","RuntimeException","Java"));
//		assertTrue(q.getId() > 0);
//		assertEquals(count+1, questionService.count());
	}

}
