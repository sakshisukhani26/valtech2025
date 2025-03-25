package com.valtech.training.quizservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.quizservice.services.QuestionResultService;
import com.valtech.training.quizservice.vos.QuestionResultVO;

@RestController
@RequestMapping("/api/v1/QuestionResult")
public class QuestionResultController {

	@Autowired
	private QuestionResultService questionResultService;
	
	
	@PostMapping("/")
	public QuestionResultVO createQuestionResult(@RequestBody QuestionResultVO vo) {
		return questionResultService.saveQuestionResult(vo);
	}
	
	@GetMapping("/")
	public List<QuestionResultVO> getAll(){
		return questionResultService.getAll();
	}
	
	@GetMapping("/{id}")
	public QuestionResultVO getById(@PathVariable long id) {
		return questionResultService.getById(id);
	}
	
	@GetMapping("/quiz/{id}")
	public List<QuestionResultVO> getAllByQuizId(@PathVariable long id){
		return questionResultService.getAllByQuizId(id);
	}
}
