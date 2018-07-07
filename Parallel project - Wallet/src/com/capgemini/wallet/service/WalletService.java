package com.capgemini.wallet.service;

import java.math.BigDecimal;

import com.capgemini.wallet.beans.Customer;
import com.capgemini.wallet.exception.InvalidInputException;

public interface WalletService {

	public Customer createAccount(String name, String mobileno, BigDecimal amount) throws InvalidInputException;

	public Customer showBalance(String mobileno) throws InvalidInputException;

	public Customer depositAmount(String mobileNo, BigDecimal amount);

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount);

	public Customer withdrawAmount(String mobileNo, BigDecimal amount);

	public void acceptCustomerDetails(Customer cust);
}