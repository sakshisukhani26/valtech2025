package com.valtech.training.loanservice.webservices;

import java.util.List;

import org.springframework.stereotype.Component;

import com.valtech.training.loanservice.Loan;

@Component
public interface LoanServiceWS {

	List<Loan> getAllLoan();
		
	Loan createLoan(Loan l);

	Loan getById(long id);
}
