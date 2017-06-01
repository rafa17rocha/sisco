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
public class CadastrarUsuario implements Command
{

	@Override
	public void executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int pTipo = Integer.parseInt(req.getParameter("tipo"));
		String pNome = req.getParameter("nome");
		long pCpf = Long.parseLong(req.getParameter("cpf"));
		int pEmpresa = pTipo == 0 ? Integer.parseInt(req.getParameter("empresa")) : 0;
		boolean pLivreAcesso = pTipo == 0 ? Boolean.parseBoolean(req.getParameter("livreAcesso")) : true;
		boolean pAlteraAr = pTipo == 0 ? Boolean.parseBoolean(req.getParameter("alteraAr")) : true;
		String pUsuario = req.getParameter("usuario");
		String pSenha = req.getParameter("senha");
		
		String expedienteEntrada = req.getParameter("expedienteEntrada");
		String expedienteSaida = req.getParameter("expedienteSaida");
		
		String pExpediente = expedienteEntrada + " - " + expedienteSaida;

		Usuario usuario = new Usuario(0, pTipo, pNome, pCpf, pEmpresa, pExpediente, pLivreAcesso, pAlteraAr, pUsuario, pSenha);
		try
		{
			UsuarioService.cadastrar(usuario);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
		
		ArrayList<Usuario> lista = (ArrayList<Usuario>) session.getAttribute("listaUsuarios");
		
		if(lista != null)
			lista.add(usuario);
		
		req.setAttribute("usuario", usuario);
		
		session.setAttribute("listaUsuarios", lista);
		session.setAttribute("expedienteEntrada", expedienteEntrada);
		session.setAttribute("expedienteSaida", expedienteSaida);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("VisualizarUsuario.jsp");
		dispatcher.forward(req, resp);
	}
}
