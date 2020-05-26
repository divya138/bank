package com.hcl.savingaccount.dto;

import java.util.Date;

import com.hcl.savingaccount.model.Account;

public class TransactionDto {
	private int transactionId;
	private Date transactionDate;
	private double transactionamount;
	private Account account;
	private long beneficiaryAccountId;
	private String txnMsg;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getTransactionamount() {
		return transactionamount;
	}
	public void setTransactionamount(double transactionamount) {
		this.transactionamount = transactionamount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public long getBeneficiaryAccountId() {
		return beneficiaryAccountId;
	}
	public void setBeneficiaryAccountId(long beneficiaryAccountId) {
		this.beneficiaryAccountId = beneficiaryAccountId;
	}
	public String getTxnMsg() {
		return txnMsg;
	}
	public void setTxnMsg(String txnMsg) {
		this.txnMsg = txnMsg;
	}
	

}
