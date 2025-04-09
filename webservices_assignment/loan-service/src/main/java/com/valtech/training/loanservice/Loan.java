package com.valtech.training.loanservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Loan {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "loan_seq")
	@SequenceGenerator(name="loan_seq",sequenceName = "loan_seq")
	private long id;
	private String name;
	private int income;   
	private int cibilScore;
	private loanStatus status;
	private int loanAmount;
	private loanType loanType;
	private String asset;
	private int assetValue;
	private String aadharNumber;
	private String panCard;
	
	
	public enum loanStatus{
		APPLIED,APPROVED,REJECTED
	}

	public enum loanType{
		HOME,CAR
	}
	
	public Loan() {}

	
	public Loan(String name, int income, int cibilScore, loanStatus status, int loanAmount,
			loanType loanType, String asset, int assetValue, String aadharNumber,
			String panCard) {
		this.name = name;
		this.income = income;
		this.cibilScore = cibilScore;
		this.status = status;
		this.loanAmount = loanAmount;
		this.loanType = loanType;
		this.asset = asset;
		this.assetValue = assetValue;
		this.aadharNumber = aadharNumber;
		this.panCard = panCard;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
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

	public int getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(int assetValue) {
		this.assetValue = assetValue;
	}
	
	
	                                
}
