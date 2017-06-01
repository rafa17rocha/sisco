package br.usjt.arqsis.sisco.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqsis.sisco.model.Usuario;
import br.usjt.arqsis.sisco.service.UsuarioService;

public class FazerLogin implements Command
{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String login = request.getParameter("username");
		String senha = request.getParameter("passwd");

		Usuario usuario = new Usuario();
		usuario.setUsuario(login);
		usuario.setSenha(senha);

		try
		{
			if (UsuarioService.validar(usuario))
			{
				HttpSession session = request.getSession();
				session.setAttribute("logado", usuario);
				System.out.println("Logou " + usuario);
				
				response.sendRedirect("index.jsp");
			}
			else
			{
				System.out.println("Não Logou " + usuario);
				
				response.sendRedirect("LoginInvalido.jsp");
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
