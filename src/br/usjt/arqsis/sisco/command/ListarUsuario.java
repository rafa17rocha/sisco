package br.usjt.arqsis.sisco.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqsis.sisco.model.Usuario;
import br.usjt.arqsis.sisco.service.UsuarioService;

public class ListarUsuario implements Command
{

	@Override
	public void executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String nome = req.getParameter("data[search]");
		
		ArrayList<Usuario> lista = null;
		
		try
		{
			lista = UsuarioService.consultar(nome);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
		
		session.setAttribute("listaUsuarios", lista);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("usuarios.jsp");
		dispatcher.forward(req, resp);
		
	}

}
