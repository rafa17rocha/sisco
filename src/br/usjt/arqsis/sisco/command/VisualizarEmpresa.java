package br.usjt.arqsis.sisco.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.usjt.arqsis.sisco.model.Empresa;
import br.usjt.arqsis.sisco.service.EmpresaService;

public class VisualizarEmpresa implements Command
{
	@Override
	public void executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String reqId = req.getParameter("id");
		
		int id = Integer.parseInt(reqId);
		
		Empresa empresa = null;
		String horarioFuncionamentoInicial = null;
		String horarioFuncionamentoFinal = null;
		String horarioArInicial= null;
		String horarioArFinal = null;
		
		try
		{
			empresa = EmpresaService.consultar(id);
			
			horarioFuncionamentoInicial = empresa.getHorarioDeFuncionamento().substring(0,5);
			horarioFuncionamentoFinal = empresa.getHorarioDeFuncionamento().substring(8,13);
			horarioArInicial = empresa.getHorarioDoAr().substring(0,5);
			horarioArFinal = empresa.getHorarioDoAr().substring(8,13);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
		
		session.setAttribute("empresa", empresa);
		session.setAttribute("horarioFuncionamentoInicial", horarioFuncionamentoInicial);
		session.setAttribute("horarioFuncionamentoFinal", horarioFuncionamentoFinal);
		session.setAttribute("horarioArInicial", horarioArInicial);
		session.setAttribute("horarioArFinal", horarioArFinal);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("VisualizarEmpresa.jsp");
		dispatcher.forward(req, resp);
		
	}
}
