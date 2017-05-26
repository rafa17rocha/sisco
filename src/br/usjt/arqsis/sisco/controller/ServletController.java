package br.usjt.arqsis.sisco.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqsis.sisco.command.Command;

@WebServlet("/controller.do")
public class ServletController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	protected void doExecute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException
	{
		String commandPackage = "br.usjt.arqsis.sisco.command.";
		try
		{
			req.setCharacterEncoding("UTF-8");
			Command comando = (Command) Class.forName(commandPackage + req.getParameter("command")).newInstance();
			comando.executar(req, resp);
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	{
		try
		{
			doExecute(req, resp);
		}
		catch (ServletException | IOException | SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		try
		{
			doExecute(req, resp);
		}
		catch (ServletException | IOException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
