package br.usjt.arqsis.sisco.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqsis.sisco.model.Usuario;
import br.usjt.arqsis.sisco.service.UsuarioService;

@SuppressWarnings("unchecked")
public class ExcluirUsuario implements Command
{
	
	@Override
	public void executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int pId = Integer.parseInt(req.getParameter("id"));
		
		Usuario usuario = new Usuario();
		usuario.setId(pId);
		
		try
		{
			UsuarioService.excluir(usuario);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
				
		ArrayList<Usuario> lista = (ArrayList<Usuario>) session.getAttribute("listaUsuarios");
		alterarLista(usuario, lista);
		
		session.setAttribute("listaUsuarios", lista);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("usuarios.jsp");
		dispatcher.forward(req, resp);
	}
	
	public void alterarLista(Usuario user, ArrayList<Usuario> lista)
	{
		for(int i = 0; i < lista.size(); i++)
		{
			if(lista.get(i).getId() == user.getId())
			{
				lista.remove(i);
				break;
			}
		}
	}

}
