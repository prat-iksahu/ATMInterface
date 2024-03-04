package com.atm;

import java.util.Scanner;

public class Runner {
	static boolean login = true, selection;
	static ATM atm = new ATM();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String userId = "";
		while (login) {
			userId = login();
			selection = true;
		}
		optionSelection(userId);

	}

	private static String login() {
		System.out.println("Enter you Id: ");
		String userId = sc.next();
		System.out.println("Enter password: ");
		String password = sc.next();
		if (atm.authenticateUser(userId, password)) {
			login = false;
		}
		return userId;
	}

	private static void optionSelection(String userId) {
		System.out.println("Select One of the option:\nA.Deposit. \nB.Check Balance. \nC.Withdraw.");
		char opt = sc.next().charAt(0);
		while (selection) {
			if (opt == 'A' || opt == 'a') {
				System.out.println("Enter deposit amount:");
				int amt = sc.nextInt();
				atm.depositAmount(userId, amt);
				System.out.println("Your balance is amount: " + atm.checkBalance(userId));
				System.out.println("Do you want to continue");
				char ans = sc.next().charAt(0);
				if (ans == 'Y' || ans == 'y')
					optionSelection(userId);
				else {
					System.out.println("Thank you");
					selection = false;
				}

			} else if (opt == 'B' || opt == 'b') {
				System.out.println("Your balance is amount:" + atm.checkBalance(userId));
				System.out.println("Do you want to continue");
				char ans = sc.next().charAt(0);
				if (ans == 'Y' || ans == 'y')
					optionSelection(userId);
				else {
					System.out.println("Thank you");
					selection = false;
				}

			} else if (opt == 'C' || opt == 'c') {
				System.out.println("Enter withdraw amount:");
				int amt = sc.nextInt();
				atm.withdrawAmount(userId, amt);
				System.out.println("Your balance is amount: " + atm.checkBalance(userId));
				System.out.println("Do you want to continue");
				char ans = sc.next().charAt(0);
				if (ans == 'Y' || ans == 'y')
					optionSelection(userId);
				else {
					System.out.println("Thank you");
					selection = false;
				}

			}
		}
	}

}
