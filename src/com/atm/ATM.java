package com.atm;

import java.util.HashMap;
import java.util.Map;

import com.atm.model.User;

public class ATM {
	Map<String, User> accountList;

	public ATM() {
		User user1 = new User();
		user1.setUserID("Pratik");
		user1.setUserPin("1234");
		user1.setBalance(8000.0);

		User user2 = new User();
		user2.setUserID("Veritech");
		user2.setUserPin("4321");
		user2.setBalance(70000.0);
		accountList = new HashMap<String, User>();
		accountList.put(user1.getUserID(), user1);
		accountList.put(user2.getUserID(), user2);
	}

	public boolean authenticateUser(String userId, String pin) {
		User user = accountList.get(userId);
		if (user != null && user.getUserPin().equalsIgnoreCase(pin)) {
			return true;
		}
		return false;
	}

	public double checkBalance(String userID) {

		return accountList.get(userID).getBalance();
	}

	public void depositAmount(String userId, int amt) {
		accountList.get(userId).setBalance(accountList.get(userId).getBalance() + amt);
	}

	public void withdrawAmount(String userId, int amt) {
		accountList.get(userId).setBalance(accountList.get(userId).getBalance() - amt);

	}
}
