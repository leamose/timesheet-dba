package br.com.dba.timesheet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public Conexao() {
		try{
			String driver = "org.postgresql.Driver";  
			String user   = "postgres";  
			String senha = "12349876";  
			String url      = "jdbc:postgresql://localhost:5432/DBA";  
	    	
	        Class.forName(driver);  
	        Connection con = null;  
	  
	        con = (Connection) DriverManager.getConnection(url, user, senha);
	  
	    }catch (ClassNotFoundException ex){  
	        System.err.print(ex.getMessage());  
	    }catch (SQLException e){  
	        System.err.print(e.getMessage());  
		} 
	}
}
