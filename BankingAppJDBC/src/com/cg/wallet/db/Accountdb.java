package com.cg.wallet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;










import com.cg.wallet.Exception.AccountException;
import com.cg.wallet.bean.Account;


public class Accountdb {
	public static Connection getConnection() throws AccountException{
		
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url,"system","orcl11g");
			}catch(ClassNotFoundException e){
			throw new AccountException(e.getMessage());
			}catch(SQLException e1){
			throw new AccountException(e1.getMessage());
			}
			 
			 
			}
}