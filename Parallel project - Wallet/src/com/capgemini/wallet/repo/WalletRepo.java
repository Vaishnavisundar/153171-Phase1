package com.capgemini.wallet.repo;

import java.math.BigDecimal;

import com.capgemini.wallet.beans.Customer;

public interface WalletRepo {

	public boolean save(Customer customer);

	public Customer findOne(String mobileNo);
}
