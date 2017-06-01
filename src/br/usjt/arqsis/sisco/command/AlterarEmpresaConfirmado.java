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

@SuppressWarnings("unchecked")
public class AlterarEmpresaConfirmado implements Command
{

	@Override
	public void executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int id = Integer.parseInt(req.getParameter("id"));		
		String razaoSocial = req.getParameter("razaoSocial");
		long cnpj = Long.parseLong(req.getParameter("cnpj"));
		int conjunto = Integer.parseInt(req.getParameter("conjunto"));
		int temperatura = Integer.parseInt(req.getParameter("temperatura"));
		
		String horarioFuncionamentoInicial = req.getParameter("horarioFuncionamentoInicial");
		String horarioFuncionamentoFinal = req.getParameter("horarioFuncionamentoFinal");
		String horarioArInicial = req.getParameter("horarioArInicial");
		String horarioArFinal = req.getParameter("horarioArFinal");
		
		String horarioFuncionamento = horarioFuncionamentoInicial + " - " + horarioFuncionamentoFinal;
		String horarioAr = horarioArInicial + " - " + horarioArFinal;

		Empresa empresa = new Empresa(id, razaoSocial, cnpj, conjunto, horarioFuncionamento, horarioAr, temperatura);
		
		try
		{
			EmpresaService.alterar(empresa);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
		
		ArrayList<Empresa> lista = (ArrayList<Empresa>) session.getAttribute("listaEmpresas");
		
		if(lista != null)
			alterarLista(empresa, lista);
		
		req.setAttribute("empresa", empresa);
		session.setAttribute("listaEmpresas", lista);
		session.setAttribute("horarioFuncionamentoInicial", horarioFuncionamentoInicial);
		session.setAttribute("horarioFuncionamentoFinal", horarioFuncionamentoFinal);
		session.setAttribute("horarioArInicial", horarioArInicial);
		session.setAttribute("horarioArFinal", horarioArFinal);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("VisualizarEmpresa.jsp");
		dispatcher.forward(req, resp);
	}
	
	public void alterarLista(Empresa emp, ArrayList<Empresa> lista)
	{
		for(int i = 0; i < lista.size(); i++)
		{
			if(lista.get(i).getId() == emp.getId())
			{
				lista.set(i, emp);
				break;
			}
		}
	}
}
