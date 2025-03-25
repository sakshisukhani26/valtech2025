package com.valtech.training.loanservice;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class Loan {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "loan_seq")
	@SequenceGenerator(name="loan_seq",sequenceName = "loan_seq")
	private long id;
	private int income;   
	private int cibilScore;
	private loanStatus status;
	private int loanAmount;
	private loanType loanType;
	private String asset;
	private String assetValue;
	
	public enum loanStatus{
		APPROVED,REJECTED
	}

	public enum loanType{
		HOME,CAR
	}
	
	public Loan() {}

	public Loan(int income, int cibilScore, loanStatus status, int loanAmount, loanType loanType, String asset,
			String assetValue) {
		super();
		this.income = income;
		this.cibilScore = cibilScore;
		this.status = status;
		this.loanAmount = loanAmount;
		this.loanType = loanType;
		this.asset = asset;
		this.assetValue = assetValue;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}

	public loanStatus getStatus() {
		return status;
	}

	public void setStatus(loanStatus status) {
		this.status = status;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public loanType getLoanType() {
		return loanType;
	}

	public void setLoanType(loanType loanType) {
		this.loanType = loanType;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public String getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(String assetValue) {
		this.assetValue = assetValue;
	}
	
	
	                                
}
