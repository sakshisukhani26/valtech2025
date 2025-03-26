package com.valtech.training.loanservice.services;

import java.util.List;

import com.valtech.training.loanservice.Loan;

public interface LoanService {

	Loan createLoan(Loan l);

	List<Loan> getAll();

	Loan getLoan(long id);

	Loan processLoan(Loan loan);

	Loan applyLoan(Loan loan);

}