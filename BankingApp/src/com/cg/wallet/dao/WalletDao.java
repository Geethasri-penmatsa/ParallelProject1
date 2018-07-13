package com.cg.wallet.dao;

import java.util.HashMap;

import com.cg.wallet.Exception.AccountException;
import com.cg.wallet.bean.Account;
import com.cg.wallet.db.Accountdb;

public class WalletDao implements IWallet {
	private static HashMap<String, Account> walletMap = Accountdb.getAccdb();
	@Override
	public String createAccount(Account acc) throws AccountException {
		walletMap.put(acc.getMobileNo(), acc);
		
		 return acc.getMobileNo();
	}

	@Override
	public double showBalance(String mobileNo) throws AccountException {
		
		Account acc = walletMap.get(mobileNo);
		if (acc == null) {
			throw new AccountException("The mobile number does not exist");
		}
		return acc.getBalance();
	}

	@Override
	public Account deposit(String mobileNo) throws AccountException {
	
		Account acc = walletMap.get(mobileNo);
		if (acc == null) {
			throw new AccountException("The mobile number does not exist");
		}
		return acc;
	}

	@Override
	public Account withdraw(String mobileNo) throws AccountException {
		Account acc = walletMap.get(mobileNo);
		if (acc == null) {
			throw new AccountException("The mobile number does not exist");
		}
		return acc;
	}

	@Override
	public Account printTransactionDetails(String mobileNo)
			throws AccountException {
		Account acc = walletMap.get(mobileNo);
		if (acc == null) {
			throw new AccountException("The mobile number does not exist");
		}
		return acc;
	}
	}


