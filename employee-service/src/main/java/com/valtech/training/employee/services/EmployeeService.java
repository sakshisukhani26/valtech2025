package com.valtech.training.employee.services;

import java.util.List;

import com.valtech.training.employee.vos.QuestionVO;

public interface EmployeeService {

	QuestionVO saveOrUpdateEmployee(QuestionVO employee);

	QuestionVO getEmployee(long id);

	List<QuestionVO> getEmployees();

}