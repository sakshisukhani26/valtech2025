package com.valtech.training.loanserviceclient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.loanservice.Loan;
import com.valtech.training.loanservice.Loan.loanStatus;
import com.valtech.training.loanservice.Loan.loanType;
import com.valtech.training.loanservice.webservices.LoanServiceWS;

@SpringBootTest
class LoanServiceClientApplicationTests {

	@Autowired
	private LoanServiceWS loanServiceWS;
	
	@Test
	void contextLoads() {
		loanServiceWS.createLoan(new Loan("Sakshi", 50000, 700,loanStatus.APPLIED , 100000, loanType.valueOf("CAR"), "car", 10000, 1234,123));
//		loanServiceWS.createLoan(new Loan("Sakshi", 50000, 700, loanStatus.APPLIED, 100000, loanType.valueOf("CAR"), "car", 0, 0, 0)));
	}

}
