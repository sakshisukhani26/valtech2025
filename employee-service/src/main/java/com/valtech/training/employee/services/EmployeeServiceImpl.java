package com.valtech.training.employee.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.employee.entities.Employee;
import com.valtech.training.employee.repos.EmployeeRepo;
import com.valtech.training.employee.vos.QuestionVO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public QuestionVO saveOrUpdateEmployee(QuestionVO employee) {
		Employee manager = employee.managerId() == 0 ? null : employeeRepo.getReferenceById(employee.managerId());
		Employee emp = employeeRepo.save(employee.to(manager));
		return QuestionVO.from(emp);
	}
	
	@Override
	public QuestionVO getEmployee(long id) {
		return QuestionVO.from(employeeRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuestionVO> getEmployees(){
		return employeeRepo.findAll().stream().map(e -> QuestionVO.from(e)).collect(Collectors.toList());
	}
}
