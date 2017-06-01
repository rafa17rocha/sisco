package br.usjt.arqsis.sisco.service;

import br.usjt.arqsis.sisco.dao.UsuarioDAO;
import br.usjt.arqsis.sisco.model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioService
{
	public static Usuario consultar(int id) throws SQLException, ClassNotFoundException
	{
		return UsuarioDAO.consultar(id);
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
	
	public static ArrayList<Usuario> consultar(String nome) throws ClassNotFoundException, SQLException
	{
		return UsuarioDAO.consultar(nome);
	}
	
	public static boolean validar(Usuario usuario) throws ClassNotFoundException, SQLException
	{
		return UsuarioDAO.validar(usuario);
	}
}