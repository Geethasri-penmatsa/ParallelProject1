package com.cg.wallet.service;

import com.cg.wallet.Exception.AccountException;
import com.cg.wallet.bean.Account;

public interface IWalletService {
	String createAccount(Account acc) throws AccountException;
	double showBalance(String mobileNo) throws  AccountException;
	Account deposit(String mobileNo,double depositAmt) throws  AccountException;
	Account withdraw(String mobileNo,double withdrawAmt) throws  AccountException;
	boolean fundTransfer(String sourceMobileNo,String destMobileNo,double transferAmt) throws  AccountException;
	Account printTransactionDetails(String mobileNo) throws  AccountException;
}
