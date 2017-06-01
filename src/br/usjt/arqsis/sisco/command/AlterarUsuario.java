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
		String reqId = req.getParameter("id");
		
		int id = Integer.parseInt(reqId);
		
		Usuario usuario = null;
		String expedienteEntrada = null;
		String expedienteSaida = null;
		
		try
		{
			usuario = UsuarioService.consultar(id);
			expedienteEntrada = usuario.getExpediente().substring(0,5);
			expedienteSaida = usuario.getExpediente().substring(8,13);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
		
		
		
		session.setAttribute("usuario", usuario);
		session.setAttribute("expedienteEntrada", expedienteEntrada);
		session.setAttribute("expedienteSaida", expedienteSaida);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("AlterarUsuario.jsp");
		dispatcher.forward(req, resp);
		
	}
}
