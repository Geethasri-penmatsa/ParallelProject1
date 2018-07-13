package com.cg.wallet.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.wallet.Exception.AccountException;
import com.cg.wallet.bean.Account;
import com.cg.wallet.service.IWalletService;
import com.cg.wallet.service.WalletServiceImpl;

public class WalletTest {
private IWalletService service;
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}
*/
@Before
public void init() {
	service = new WalletServiceImpl();
}

@Test
public void testCreateAccountForMobile() {
	Account ac = new Account();
	ac.setMobileNo("1234");
	ac.setName("Mary");
	ac.setEmail("mary@gmail.com");
	ac.setBalance(200.0);
	try {
		service.createAccount(ac);
	} catch (AccountException e) {
		Assert.assertEquals("Mobile number should contain 10 digits", e.getMessage());
	}
}

@Test
public void testCreateAccountForName() {
	Account ac = new Account();
	ac.setMobileNo("1234567890");
	ac.setName("mark34");
	ac.setEmail("mark@gmail.com");
	ac.setBalance(500.0);
	try {
		service.createAccount(ac);
	} catch (AccountException e) {
		Assert.assertEquals("Name should start with capital letter and should contain only alphabets", e.getMessage());
	}
}

@Test
public void testCreateAccountForNameIsEmpty() {
	Account ac = new Account();
	ac.setMobileNo("1234567890");
	ac.setName("");
	ac.setEmail("rito70@gmail.com");
	ac.setBalance(200.0);
	try {
		service.createAccount(ac);
	} catch (AccountException e) {
		Assert.assertEquals("Name cannot be empty", e.getMessage());
	}
}

@Test
public void testCreateAccountForEmailId() {
	Account ac = new Account();
	ac.setMobileNo("1234567890");
	ac.setName("GeethaS");
	ac.setEmail("geetha@@97gmail.com");
	ac.setBalance(200.0);
	try {
		service.createAccount(ac);
	} catch ( AccountException e) {
		Assert.assertEquals("Enter valid emailid", e.getMessage());
	}
}

@Test
public void testCreateAccountForBalance() {
	Account ac = new Account();
	ac.setMobileNo("1234567890");
	ac.setName("Geetha");
	ac.setEmail("geetha@gmail.com");
	ac.setBalance(0);
	try {
		service.createAccount(ac);
	} catch (AccountException e) {
		Assert.assertEquals("Balance should be greater than zero", e.getMessage());
	}
}

@Test
public void testCreateAccount() {
	Account ac = new Account();
	ac.setMobileNo("1234567890");
	ac.setName("Anna");
	ac.setEmail("Anna@gmail.com");
	ac.setBalance(200.0);
	
		try {
			String s=service.createAccount(ac);
			Assert.assertNotNull(s);
		} catch (AccountException e) {
			
			
		}
	
}

@Test
public void testShowBalanceForMobileNo() {
	
	try {
		service.showBalance("95059");
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
}


@Test
public void testShowBalanceForMobileNoDoesNotExist() {
	
	try {
		service.showBalance("9246521447");
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
}


@Test
public void testShowBalanceForName() {
	Account ac=new Account();
	ac.setMobileNo("9505929555");
	try {
		service.showBalance(ac.getMobileNo());
		assertEquals("Geetha", ac.getName());
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
}

@Test
public void testDepositForMobileNo() {
	Account ac=new Account();
	ac.setMobileNo("95059345");
	try {
		service.deposit(ac.getMobileNo(), 230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
}
@Test
public void testDepositForMobileNoDoesNotExist() {
	Account ac=new Account();
	ac.setMobileNo("9246521445");
	try {
		service.deposit(ac.getMobileNo(), 230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
}
@Test
public void testDepositForDepositAmount() {
	Account ac=new Account();
	ac.setMobileNo("9246521446");
	try {
		service.deposit(ac.getMobileNo(), -230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("Deposit amount must be greater than zero",e.getMessage());
	}
}

@Test
public void testDeposit() {
	Account ac=new Account();
	ac.setMobileNo("9246521446");
	try {
		Account ac1=service.deposit(ac.getMobileNo(), 230);
		assertNotNull(ac1);
	} catch (AccountException e) {
		
		System.out.println(e.getMessage());
	}
}

@Test
public void testWithDrawForMobileNo() {
	Account ac=new Account();
	ac.setMobileNo("95059345");
	try {
		service.withdraw(ac.getMobileNo(), 230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
}
@Test
public void testWithdrawForMobileNoDoesNotExist() {
	Account ac=new Account();
	ac.setMobileNo("9246521445");
	try {
		service.withdraw(ac.getMobileNo(), 230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
}
@Test
public void testWithdrawForAmount() {
	Account ac=new Account();
	ac.setMobileNo("9246521446");
	try {
		service.withdraw(ac.getMobileNo(), -230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
	}
}


@Test
public void testFundTransferForMobileNo() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobileNo("95059345");
	ac2.setMobileNo("1234");
	try {
		service.fundTransfer(ac.getMobileNo(),ac2.getMobileNo(), 230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
}
@Test
public void testFundTransferForMobileNoDoesNotExist() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobileNo("9246521445");
	ac2.setMobileNo("9246521445");
	try {
		service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
}
@Test
public void testFundTransferForAmount() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobileNo("9246521447");
	ac2.setMobileNo("9246521446");
	try {
		service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  -230);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		Assert.assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
	}
}
@Test
public void testFundTransfer() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobileNo("9246521445");
	ac2.setMobileNo("9246521447");
	try {
		assertTrue(service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  230));
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
}
@Test
public void testPrinttransactionDetails() {
	Account ac=new Account();
	ac.setMobileNo("9246521445");
	try {
		Account acc=service.printTransactionDetails(ac.getMobileNo());
		assertNotNull(acc);
	} catch (AccountException e) {
		System.out.println(e.getMessage());
	}
	
}


}

