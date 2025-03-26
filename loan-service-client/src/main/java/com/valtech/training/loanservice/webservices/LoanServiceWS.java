package com.valtech.training.loanservice.webservices;

import java.util.List;

import com.valtech.training.loanservice.Loan;

import jakarta.jws.WebService;

@WebService
public interface LoanServiceWS {

	List<Loan> getAllLoan();
	
	Loan createLoan(Loan l);

	Loan getById(long id);
}

