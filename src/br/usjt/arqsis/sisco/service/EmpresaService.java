package br.usjt.arqsis.sisco.service;

import br.usjt.arqsis.sisco.dao.EmpresaDAO;
import br.usjt.arqsis.sisco.model.Empresa;
import java.sql.SQLException;

public class EmpresaService
{
	public static Empresa consultar(int id) throws SQLException, ClassNotFoundException
	{
		return EmpresaDAO.consultar(id);
	}

	public static boolean cadastrar(Empresa emp) throws SQLException, ClassNotFoundException
	{
		return EmpresaDAO.cadastrar(emp);
	}

	public static boolean alterar(Empresa emp) throws SQLException, ClassNotFoundException
	{
		return EmpresaDAO.alterar(emp);
	}

	public static boolean excluir(Empresa emp) throws SQLException, ClassNotFoundException
	{
		return EmpresaDAO.excluir(emp);
	}
}