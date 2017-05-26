package br.usjt.arqsis.sisco.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory
{
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		String local = "jdbc:mysql://localhost:3306/sistemapredial";
		String param = "?useSSL=false&allowMultiQueries=true";

		return DriverManager.getConnection(local + param, "alunos", "alunos");
	}
}
