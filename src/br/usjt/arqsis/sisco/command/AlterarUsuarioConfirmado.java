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

@SuppressWarnings("unchecked")
public class AlterarUsuarioConfirmado implements Command
{

	@Override
	public void executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int pId = Integer.parseInt(req.getParameter("id"));
		int pTipo = Integer.parseInt(req.getParameter("tipo"));
		String pNome = req.getParameter("nome");
		long pCpf = Long.parseLong(req.getParameter("cpf"));
		int pEmpresa = Integer.parseInt(req.getParameter("empresa"));
		boolean pLivreAcesso = Boolean.parseBoolean(req.getParameter("livreAcesso"));
		boolean pAlteraAr = Boolean.parseBoolean(req.getParameter("alteraAr"));
		String pUsuario = req.getParameter("usuario");
		String pSenha = req.getParameter("senha");
		
		String expedienteEntrada = req.getParameter("expedienteEntrada");
		String expedienteSaida = req.getParameter("expedienteSaida");
		
		String pExpediente = expedienteEntrada + " - " + expedienteSaida;
		
		Usuario usuario = new Usuario(pId, pTipo, pNome, pCpf, pEmpresa, pExpediente, pLivreAcesso, pAlteraAr, pUsuario, pSenha);
		try
		{
			UsuarioService.alterar(usuario);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
		
		ArrayList<Usuario> lista = (ArrayList<Usuario>) session.getAttribute("listaUsuarios");
		
		if(lista != null)
			alterarLista(usuario, lista);
		
		req.setAttribute("usuario", usuario);
		session.setAttribute("listaUsuarios", lista);
		session.setAttribute("expedienteEntrada", expedienteEntrada);
		session.setAttribute("expedienteSaida", expedienteSaida);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("VisualizarUsuario.jsp");
		dispatcher.forward(req, resp);
	}
	
	public void alterarLista(Usuario user, ArrayList<Usuario> lista)
	{
		for(int i = 0; i < lista.size(); i++)
		{
			if(lista.get(i).getId() == user.getId())
			{
				lista.set(i, user);
				break;
			}
		}
	}
}
