package com.valtech.training.loanservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.loanservice.Loan;

public interface LoanRepo extends JpaRepository<Loan, Long>{

}
