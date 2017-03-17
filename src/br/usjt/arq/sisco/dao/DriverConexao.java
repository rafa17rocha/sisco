package br.usjt.arq.sisco.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DriverConexao
{
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		String local = "jdbc:mysql://localhost:3306/sistemapredial";
		String param = "?useSSL=false&allowMultiQueries=true";
		
		return DriverManager.getConnection(local + param, "alunos", "alunos");
	}
}
