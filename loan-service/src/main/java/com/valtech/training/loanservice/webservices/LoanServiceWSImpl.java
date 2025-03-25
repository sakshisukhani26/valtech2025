package com.valtech.training.loanservice.webservices;

import java.util.List;

import com.valtech.training.loanservice.Loan;
import com.valtech.training.loanservice.services.LoanService;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.valtech.training.loanservice.webservices.LoanServiceWS",name="LoanService",portName = "LoanServicePort")
public class LoanServiceWSImpl implements LoanServiceWS{

	private LoanService loanService;
	
	public LoanServiceWSImpl(LoanService loanService) {
		this.loanService = loanService;
	}
	
	@Override
	public List<Loan> getAllLoan() {
		return loanService.getAll();
	}

	@Override
	public Loan createLoan(Loan l) {
		return loanService.createLoan(l);
	}

	@Override
	public Loan getById(long id) {
		return loanService.getLoan(id);
	}

}
