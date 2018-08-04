package com.cg.wallet.dao;

import com.cg.wallet.Exception.AccountException;
import com.cg.wallet.bean.Account;

public interface IWallet {
	String createAccount(Account acc) throws AccountException;
	double showBalance(String mobileNo) throws AccountException;
	Account deposit(String mobileNo,double depAmt) throws AccountException;
	Account withdraw(String mobileNo, double withdrawAmt) throws AccountException;

Account printTransactionDetails(String mobileNo) throws AccountException;

}
