package br.usjt.arqsis.sisco.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqsis.sisco.model.Usuario;
import br.usjt.arqsis.sisco.service.UsuarioService;

public class AlterarUsuario implements Command
{
	@Override
	public void executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String reqCpf = req.getParameter("cpf");
		
		long cpf = Long.parseLong(reqCpf);
		
		Usuario usuario = null;
		
		try
		{
			usuario = UsuarioService.consultar(cpf);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
		
		session.setAttribute("usuario", usuario);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("AlterarUsuario.jsp");
		dispatcher.forward(req, resp);
		
	}
}
