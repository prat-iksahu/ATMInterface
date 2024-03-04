package com.atm.util;

import java.util.Map;

import com.atm.model.User;

public class AccountData {
	Map<String, User> accountList;
	{
		User user1 = new User();
		user1.setUserID("Pratik");
//		user1.setUserPin(1234);
		user1.setBalance(8000.0);

		User user2 = new User();
		user2.setUserID("Veritech");
//		user2.setUserPin(4321);
		user2.setBalance(70000.0);

		accountList.put(user1.getUserID(), user1);
		accountList.put(user2.getUserID(), user2);
	}

	public Map<String, User> getAccountList() {
		return accountList;
	}

}
