package br.usjt.arq.sisco.service;

import br.usjt.arq.sisco.dao.EmpresaDAO;
import br.usjt.arq.sisco.model.Empresa;
import java.sql.SQLException;

public class EmpresaService
{
	public static Empresa consultar(long emp) throws SQLException, ClassNotFoundException
	{
		return EmpresaDAO.consultar(emp);
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