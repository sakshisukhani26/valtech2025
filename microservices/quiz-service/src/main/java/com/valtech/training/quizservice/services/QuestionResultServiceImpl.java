package com.valtech.training.quizservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.quizservice.entities.QuestionResult;
import com.valtech.training.quizservice.repos.QuestionResultRepo;
import com.valtech.training.quizservice.repos.QuizRepo;
import com.valtech.training.quizservice.vos.QuestionResultVO;
import com.valtech.training.quizservice.vos.QuestionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionResultServiceImpl implements QuestionResultService {

	@Autowired
	private QuestionResultRepo questionResultRepo;
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionClient questionClient;
	
	@Override
	public QuestionResultVO saveQuestionResult(QuestionResultVO vo) {
		QuestionResult qr = vo.to(quizRepo.getReferenceById(vo.quizId()));
		QuestionVO questionVO = questionClient.findQuestionById(vo.quesId());
		String correctOption = questionVO.correctOption();
		boolean result = false;;
		if(vo.userAnswer().equals(correctOption)) {
			result = true;
		}
		qr.setResult(result);
		questionResultRepo.save(qr);
		return QuestionResultVO.from(qr);
	}
	
	@Override
	public QuestionResultVO getById(long id) {
		return QuestionResultVO.from(questionResultRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuestionResultVO> getAll(){
		return questionResultRepo.findAll().stream().map(qr -> QuestionResultVO.from(qr)).collect(Collectors.toList());
	}
	
	public List<QuestionResultVO> getAllByQuizId(long id){
		return questionResultRepo.findAllQuestionResultsByQuizId(id).stream().map(qr -> QuestionResultVO.from(qr)).collect(Collectors.toList());
	}
}
