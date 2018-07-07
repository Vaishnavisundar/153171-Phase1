package com.capgemini.wallet.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.wallet.beans.Customer;
import com.capgemini.wallet.beans.Wallet;
import com.capgemini.wallet.exception.InvalidInputException;
import com.capgemini.wallet.service.WalletService;
import com.capgemini.wallet.service.WalletServiceImpl;

public class TestClass {

	WalletService service;
	Customer cust1, cust2, cust3;

	@Before
	public void initData() {
		Map<String, Customer> data = new HashMap<String, Customer>();
		cust1 = new Customer("abcd", "1234567895", new Wallet(new BigDecimal(9000)));
		cust2 = new Customer("efgh", "9874563215", new Wallet(new BigDecimal(6000)));
		cust3 = new Customer("ijkl", "9954789654", new Wallet(new BigDecimal(7000)));

		data.put("1234567895", cust1);
		data.put("9874563215", cust2);
		data.put("9954789654", cust3);
		service = new WalletServiceImpl(data);

	}

	@Test
	public void testCreateAccount1() {

		Customer customer = new Customer();
		Customer cust = new Customer();
		cust = service.createAccount("abcd", "1234567895", new BigDecimal(9000));
		customer.setMobileNo("1234567895");
		customer.setName("abcd");
		customer.setWallet(new Wallet(new BigDecimal(9000)));
		Customer actual = customer;
		Customer expected = cust;
		assertEquals(expected, actual);

	}

	@Test(expected = NullPointerException.class)
	public void testCreateAccount() {

		service.createAccount(null, null, null);

	}

	@Test
	public void testCreateAccount2() {

		Customer cust = new Customer();
		cust = service.createAccount("efgh", "9874563215", new BigDecimal(7000));
		assertEquals("efgh", cust.getName());

	}

	@Test
	public void testCreateAccount3() {

		Customer cust = new Customer();
		cust = service.createAccount("ijkl", "9954789654", new BigDecimal(7000));
		assertEquals("9954789654", cust.getMobileNo());

	}

	@Test(expected = InvalidInputException.class)
	public void testShowBalance() {
		Customer cust = new Customer();
		cust = service.showBalance("9954789654");

	}

	@Test
	public void testShowBalance2() {

		Customer cust = new Customer();

		cust = service.showBalance("1234567895");
		assertEquals(cust, cust3);

	}

	@Test
	public void testShowBalance3() {

		Customer cust = new Customer();
		cust = service.showBalance("9874563215");
		BigDecimal actual = cust.getWallet().getBalance();
		BigDecimal expected = new BigDecimal(9000);
		assertEquals(expected, actual);

	}

	@Test(expected = InvalidInputException.class)
	public void testFundTransfer() {
		service.fundTransfer(null, null, new BigDecimal(6000));
	}

	@Test
	public void testFundTransfer2() {
		cust1 = service.fundTransfer("1234567895", "9874563215", new BigDecimal(2000));
		BigDecimal actual = cust1.getWallet().getBalance();
		BigDecimal expected = new BigDecimal(7000);
		assertEquals(expected, actual);
	}

	@Test(expected = InvalidInputException.class)
	public void testDeposit() {
		service.depositAmount("50000000", new BigDecimal(2000));
	}

	@Test
	public void testDeposit2() {
		cust1 = service.depositAmount("9963242422", new BigDecimal(2000));
		BigDecimal actual = cust1.getWallet().getBalance();
		BigDecimal expected = new BigDecimal(8000);
		assertEquals(expected, actual);
	}

	@Test(expected = InvalidInputException.class)
	public void testWithdraw() {
		service.withdrawAmount("50000000", new BigDecimal(2000));
	}

	@Test
	public void testWithdraw2() {
		cust1 = service.withdrawAmount("9963242422", new BigDecimal(2000));
		BigDecimal actual = cust1.getWallet().getBalance();
		BigDecimal expected = new BigDecimal(4000);
		assertEquals(expected, actual);
	}

	@Test
	public void TestValidate() {
		Customer customer = new Customer("abcd", "8796543210", new Wallet(new BigDecimal(10)));
		service.acceptCustomerDetails(customer);
	}

	@After
	public void testAfter() {
		service = null;
	}

}
