package br.usjt.arqsis.sisco.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqsis.sisco.model.Usuario;
import br.usjt.arqsis.sisco.service.UsuarioService;
import br.usjt.arqsis.sisco.util.JSonFacade;

@WebServlet("/usuario")
public class ServicoManterUsuario extends HttpServlet
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
	
	// Lista Usuários
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String chave = req.getParameter("chave");
		ArrayList<Usuario> lista = null;
		
		PrintWriter out = resp.getWriter();
		
		try
		{
			// PODE DAR PROBLEMA AQUI
			lista = UsuarioService.consultar(chave);
			out.println(JSonFacade.listToJSon(lista));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}
	
	// Inclui Usuário
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		StringBuilder sb = JSonFacade.montaJSon(req);
		PrintWriter out = resp.getWriter();
		
		try
		{
			Usuario u = JSonFacade.jSonToUsuario(sb.toString());
			UsuarioService.cadastrar(u);
			
			out.println(JSonFacade.usuarioToJSon(u));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}
	
	// Atualiza Usuário
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		StringBuilder sb = JSonFacade.montaJSon(req);
		PrintWriter out = resp.getWriter();
		
		try
		{
			Usuario u = JSonFacade.jSonToUsuario(sb.toString());
			UsuarioService.alterar(u);
			
			out.println(JSonFacade.usuarioToJSon(u));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}
	
	
	// Deleta Usuário
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		StringBuilder sb = JSonFacade.montaJSon(req);
		PrintWriter out = resp.getWriter();
		
		try
		{
			Usuario u = JSonFacade.jSonToUsuario(sb.toString());
			
			// Caso usuario tenha sido deletado com sucesso, o objeto Usuario U
			// é referenciado para um novo objeto vazio e retornado
			
			if(UsuarioService.excluir(u))
				u = new Usuario();
			
			out.print(JSonFacade.usuarioToJSon(u));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
		}
	}
}
