package br.usjt.arq.sisco.service;

import br.usjt.arq.sisco.dao.UsuarioDAO;
import br.usjt.arq.sisco.model.Usuario;
import java.sql.SQLException;

public class UsuarioService
{
	public static Usuario consultar(long user) throws SQLException, ClassNotFoundException
	{
		return UsuarioDAO.consultar(user);
	}

	public static boolean cadastrar(Usuario user) throws SQLException, ClassNotFoundException
	{
		return UsuarioDAO.cadastrar(user);
	}

	public static boolean alterar(Usuario user) throws SQLException, ClassNotFoundException
	{
		return UsuarioDAO.alterar(user);
	}

	public static boolean excluir(Usuario user) throws SQLException, ClassNotFoundException
	{
		return UsuarioDAO.excluir(user);
	}
}