package com.capgemini.wallet.beans;

public class Customer {

	private String name;
	private String mobileNo;
	private Wallet wallet;

	public Customer() {
		super();
		this.name = "name";
		this.mobileNo = "1234567895";
		this.wallet = wallet;
	}

	public Customer(String name, String mobileNo, Wallet wallet) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.wallet = wallet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "\n Name : " + name + "\n Mobile Number : " + mobileNo + "\n Wallet : " + wallet ;
	}

}
