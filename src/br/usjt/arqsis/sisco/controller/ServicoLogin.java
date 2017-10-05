package br.usjt.arqsis.sisco.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqsis.sisco.model.Usuario;
import br.usjt.arqsis.sisco.service.UsuarioService;
import br.usjt.arqsis.sisco.util.JSonFacade;

@WebServlet("/login")
public class ServicoLogin extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	// Configura a Request e Response para todos os métodos
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		super.service(req, resp);
	}
	
	// Tenta efetuar login
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario();
		
		usuario.setUsuario(login);
		usuario.setSenha(senha);
		
		PrintWriter out = resp.getWriter();
		
		try
		{
			boolean validado = UsuarioService.validar(usuario);
			
			if(validado)
				out.println(JSonFacade.usuarioToJSon(usuario));
		}
		
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}
}
