package com.andre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		final String LOGIN = "root";
		final String PASSWORD = "Andrelac24";
		final String url = "jdbc:mysql://localhost:3306/testDB";		
		
		try{
			Connection conn = DriverManager.getConnection(url, LOGIN , PASSWORD);
			Statement statement = conn.createStatement();
			statement.execute("create table if not exists contatos(nome TEXT, fone INTEGER, email TEXT) ");
			ResultSet resultado = statement.executeQuery("select * from contatos");
			while(resultado.next()) {
				System.out.println(resultado.getString(1)+ " " +
									resultado.getString(3)+ " " + 
									resultado.getInt(2));
			}
			resultado.close();
			statement.close();
			conn.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}	
	}
}
