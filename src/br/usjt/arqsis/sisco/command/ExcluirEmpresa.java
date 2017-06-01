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

import br.usjt.arqsis.sisco.model.Empresa;
import br.usjt.arqsis.sisco.service.EmpresaService;

@SuppressWarnings("unchecked")
public class ExcluirEmpresa implements Command
{
	
	@Override
	public void executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int pId = Integer.parseInt(req.getParameter("id"));
		
		Empresa empresa = new Empresa();
		empresa.setId(pId);
		
		try
		{
			EmpresaService.excluir(empresa);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
				
		ArrayList<Empresa> lista = (ArrayList<Empresa>) session.getAttribute("listaEmpresas");
		alterarLista(empresa, lista);
		
		session.setAttribute("listaEmpresas", lista);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("empresas.jsp");
		dispatcher.forward(req, resp);
	}
	
	public void alterarLista(Empresa emp, ArrayList<Empresa> lista)
	{
		for(int i = 0; i < lista.size(); i++)
		{
			if(lista.get(i).getId() == emp.getId())
			{
				lista.remove(i);
				break;
			}
		}
	}

}
