package com.valtech.training.employee.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.employee.vos.QuestionVO;

import java.util.List;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {
	
	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void addEmployees() {
		List emps = restTemplate.getForObject("http://localhost:"+port+"/api/v1/employees/",List.class);
		if(emps.size()==0) {
			System.out.println("Creating employees");
			QuestionVO manager = restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/"
					, new QuestionVO(0, "Abc", 123123123, "abc@gmail.com", 0), QuestionVO.class);
			QuestionVO manager1 = restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/"
					, new QuestionVO(0, "Def", 123123456, "def@gmail.com", manager.id()), QuestionVO.class);
			QuestionVO emp1 = restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/"
					, new QuestionVO(0, "Pqr", 123456123, "pqr@gmail.com", manager1.id()), QuestionVO.class);
			QuestionVO emp2 = restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/"
					, new QuestionVO(0, "Xyz", 123456789, "xyz@gmail.com", manager.id()), QuestionVO.class);
			QuestionVO emp3 = restTemplate.postForObject("http://localhost:"+port+"/api/v1/employees/"
					, new QuestionVO(0, "Lmn", 123256789, "lmn@gmail.com", manager1.id()), QuestionVO.class);
		}
	}

}
