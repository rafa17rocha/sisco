package br.usjt.arqsis.sisco.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqsis.sisco.model.Empresa;
import br.usjt.arqsis.sisco.service.EmpresaService;

public class ListarEmpresa implements Command
{

	@Override
	public void executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String razaoSocial = req.getParameter("data[search]");
		
		ArrayList<Empresa> lista = null;
		
		try
		{
			lista = EmpresaService.consultar(razaoSocial);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
		
		session.setAttribute("listaEmpresas", lista);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("empresas.jsp");
		dispatcher.forward(req, resp);
	}
}
