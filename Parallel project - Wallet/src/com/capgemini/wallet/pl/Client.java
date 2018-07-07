package com.capgemini.wallet.pl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.capgemini.wallet.beans.Customer;
import com.capgemini.wallet.beans.Wallet;
import com.capgemini.wallet.exception.InvalidInputException;
import com.capgemini.wallet.service.WalletService;
import com.capgemini.wallet.service.WalletServiceImpl;

public class Client {

	public static void main(String[] args) throws InvalidInputException {

		Customer customer;
		Wallet wallet = new Wallet();

		Scanner sc = new Scanner(System.in);
		int choice;
		String ch;
		BigDecimal amount;

		Map<String, Customer> map;

		WalletService service;
		{
			map = new HashMap<String, Customer>();
			service = new WalletServiceImpl(map);
		}

		do {

			System.out.println("\n \t\t WELCOME TO XYZ BANK ");
			System.out.println("\n 1 : Create account ");
			System.out.println("\n 2 : Show balance ");
			System.out.println("\n 3 : Deposit ");
			System.out.println("\n 4 : Withdraw ");
			System.out.println("\n 5 : Transfer fund ");
			System.out.println("\n 6 : Print transaction");
			System.out.println("\n Enter choice");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("\n Enter the following details to create a new account");
				System.out.println("\n Name          : ");
				String name = sc.next();
				System.out.println("\n Mobile number : ");
				String mobNum = sc.next();
				amount = BigDecimal.valueOf(500);
				customer = service.createAccount(name, mobNum, amount);
				System.out.println("\n Account created successfully with a minimum balance of 500 by default");
				System.out.println(customer);
				break;

			case 2:
				System.out.println("\n Enter the mobile number : ");
				mobNum = sc.next();
				customer = service.showBalance(mobNum);
				System.out.println(customer);
				break;

			case 3:
				System.out.println("Enter Source Mobile Number: ");
				String sourceMobileNo = sc.next();
				System.out.println("Enter Target Mobile Number: ");
				String targetMobileNo = sc.next();
				System.out.println("Enter amount to transfer");
				BigDecimal amount1 = sc.nextBigDecimal();
				customer = service.fundTransfer(sourceMobileNo, targetMobileNo, amount1);
				System.out.println(customer);
				break;
			case 4:
				System.out.println("Enter Mobile Number: ");
				String mobileNo3 = sc.next();
				System.out.println("Enter amount to deposit");
				BigDecimal amount3 = sc.nextBigDecimal();
				customer = service.depositAmount(mobileNo3, amount3);
				System.out.println(customer);
				break;
			case 5:
				System.out.println("Enter Mobile Number: ");
				String mobileNo4 = sc.next();
				System.out.println("Enter amount to withdraw");
				BigDecimal amount4 = sc.nextBigDecimal();
				customer = service.withdrawAmount(mobileNo4, amount4);
				System.out.println(customer);
				break;
			case 6:
				System.out.println("Thank You");
				System.exit(0);
				break;
			default:
				System.out.println("\n Invalid choice");
				break;
			}

			System.out.println("\n Press y/n to continue : ");
			ch = sc.next();
		} while (ch.equalsIgnoreCase("y") || ch.equalsIgnoreCase("yes"));
	}

}
