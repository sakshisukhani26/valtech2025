package com.valtech.training.loanservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.loanservice.Loan;
import com.valtech.training.loanservice.Loan.loanStatus;
import com.valtech.training.loanservice.repos.LoanRepo;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepo loanRepo;
	
	@Override
	public Loan createLoan(Loan l) {
		return loanRepo.save(l);
	}
	
	@Override
	public List<Loan> getAll(){
		return loanRepo.findAll();
	}
	
	@Override
	public Loan getLoan(long id) {
		return loanRepo.getReferenceById(id);
	}
	
	@Override
	public Loan applyLoan(Loan loan) {
		loan.setStatus(loanStatus.APPLIED);
		return createLoan(loan);
	}
	
	@Override
	public Loan processLoan(Loan loan) {
		int cibilScore = loan.getCibilScore();
		int assetValue = loan.getAssetValue();
		int loanAmt = loan.getLoanAmount();
		int income = loan.getIncome();
		if(cibilScore < 600) {
			loan.setStatus(loanStatus.APPROVED);
			return loan;
		}
		else if(cibilScore < 800) {
			if(assetValue >= loanAmt * 0.7 && income * 5 >= loanAmt) {
				loan.setStatus(loanStatus.APPROVED);
				return loan;
			}
			else {
				loan.setStatus(loanStatus.REJECTED);
				return loan;
			}
		}
		else {
			if(assetValue >= loanAmt * 0.6 && income * 4 >= loanAmt) {
				loan.setStatus(loanStatus.APPROVED);
				return loan;
			}else {
				loan.setStatus(loanStatus.REJECTED);
				return loan;
			}
		}
	}
}
