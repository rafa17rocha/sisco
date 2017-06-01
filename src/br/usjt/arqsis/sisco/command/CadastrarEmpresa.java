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
public class CadastrarEmpresa implements Command
{

	@Override
	public void executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String razaoSocial = req.getParameter("razaoSocial");
		long cnpj = Long.parseLong(req.getParameter("cnpj"));
		int conjunto = Integer.parseInt(req.getParameter("conjunto"));
		int temperatura = Integer.parseInt(req.getParameter("temperatura"));
		
		String horarioFuncionamentoInicial = req.getParameter("horarioFuncionamentoInicial");
		String horarioFuncionamentoFinal = req.getParameter("horarioFuncionamentoFinal");
		String horarioArInicial= req.getParameter("horarioArInicial");
		String horarioArFinal = req.getParameter("horarioArFinal");
		
		String horarioFuncionamento = horarioFuncionamentoInicial + " - " + horarioFuncionamentoFinal;
		String horarioAr = horarioArInicial + " - " + horarioArFinal;
		
		Empresa empresa = new Empresa(0, razaoSocial, cnpj, conjunto, horarioFuncionamento, horarioAr, temperatura);
		try
		{
			EmpresaService.cadastrar(empresa);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
		
		ArrayList<Empresa> lista = (ArrayList<Empresa>) session.getAttribute("listaEmpresas");
		if(lista != null)
			lista.add(empresa);
		
		req.setAttribute("empresa", empresa);
		session.setAttribute("listaEmpresas", lista);
		session.setAttribute("horarioFuncionamentoInicial", horarioFuncionamentoInicial);
		session.setAttribute("horarioFuncionamentoFinal", horarioFuncionamentoFinal);
		session.setAttribute("horarioArInicial", horarioArInicial);
		session.setAttribute("horarioArFinal", horarioArFinal);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("VisualizarEmpresa.jsp");
		dispatcher.forward(req, resp);
	}
}
