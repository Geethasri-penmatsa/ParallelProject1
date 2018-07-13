package com.cg.wallet.db;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;




import com.cg.wallet.bean.Account;


public class Accountdb {
	private static HashMap<String,Account> accdb = new HashMap<String,Account>();

	public static HashMap<String,Account> getAccdb() {
		return accdb;
	}
	static{
		accdb.put("9246521444",  new Account("9246521444","mark77@gmail.com","Mark",3000.0));
		accdb.put("9246521445",  new Account("9246521445","anna78@gmail.com","Anna",4000.0));
		accdb.put("9246521446",  new Account("9246521446","binu79@gmail.com","Binu",1000.0));
		accdb.put("9246521447",  new Account("9246521447","ritu70@gmail.com","Ritu",1500.0));
}
}