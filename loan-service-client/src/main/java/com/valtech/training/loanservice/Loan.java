package com.valtech.training.loanservice;


public class Loan {

	private long id;
	private String name;
	private int income;   
	private int cibilScore;
	private loanStatus status;
	private int loanAmount;
	private loanType loanType;
	private String asset;
	private int assetValue;
	private long aadharNumber;
	private long panCard;
	
	public enum loanStatus{
		APPLIED,APPROVED,REJECTED
	}

	public enum loanType{
		HOME,CAR
	}

	public Loan() {}

	public Loan(String name, int income, int cibilScore, loanStatus status, int loanAmount,
			loanType loanType, String asset, int assetValue,
			long aadharNumber, long panCard) {
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

	@Override
	public String toString() {
		return "Loan [id=" + id + ", name=" + name + ", income=" + income + ", cibilScore=" + cibilScore + ", status="
				+ status + ", loanAmount=" + loanAmount + ", loanType=" + loanType + ", asset=" + asset
				+ ", assetValue=" + assetValue + ", aadharNumber=" + aadharNumber + ", panCard=" + panCard + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public long getPanCard() {
		return panCard;
	}

	public void setPanCard(long panCard) {
		this.panCard = panCard;
	}
	
	
	
}
