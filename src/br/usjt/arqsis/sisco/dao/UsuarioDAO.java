package br.usjt.arqsis.sisco.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.arqsis.sisco.dao.ConnectionFactory;
import br.usjt.arqsis.sisco.model.Usuario;

public class UsuarioDAO
{
	public static Usuario consultar(int id) throws SQLException, ClassNotFoundException
	{
		String sql = "SELECT tipo, nome, cpf, idEmpresa, expediente, livreAcesso, "
				+ "alteraAr, usuario, senha FROM usuario WHERE idUsuario = ?";

		Usuario user = null;

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement preparador = con.prepareStatement(sql))
		{
			preparador.setInt(1, id);

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next())
			{
				user = new Usuario();

				byte tipo = resultado.getByte("tipo");
				String nome = resultado.getString("nome");
				long cpf = resultado.getLong("cpf");
				int idEmpresa = resultado.getInt("idEmpresa");
				String expediente = resultado.getString("expediente");
				boolean livreAcesso = resultado.getBoolean("livreAcesso");
				boolean alteraAr = resultado.getBoolean("alteraAr");
				String usuario = resultado.getString("usuario");
				String senha = resultado.getString("senha");

				user.setId(id);
				user.setTipo(tipo);
				user.setNome(nome);
				user.setCpf(cpf);
				user.setIdEmpresa(idEmpresa);
				user.setExpediente(expediente);
				user.setLivreAcesso(livreAcesso);
				user.setAlteraAr(alteraAr);
				user.setUsuario(usuario);
				user.setSenha(senha);
			}
		}
		return user;
	}

	public static boolean cadastrar(Usuario user) throws SQLException, ClassNotFoundException
	{
		String sql = "INSERT INTO usuario (tipo, nome, cpf, idEmpresa, expediente, "
				+ "livreAcesso, alteraAr, usuario, senha) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement preparador = con.prepareStatement(sql))
		{
			preparador.setInt(1, user.getTipo());
			preparador.setString(2, user.getNome());
			preparador.setLong(3, user.getCpf());

			int idEmpresa = user.getIdEmpresa();

			if (idEmpresa == 0)
				preparador.setNull(4, java.sql.Types.INTEGER);
			else
				preparador.setInt(4, idEmpresa);

			preparador.setString(5, user.getExpediente());
			preparador.setBoolean(6, user.getLivreAcesso());
			preparador.setBoolean(7, user.getAlteraAr());
			preparador.setString(8, user.getUsuario());
			preparador.setString(9, user.getSenha());
			preparador.execute();

			String lastId = "SELECT LAST_INSERT_ID()";

			try (PreparedStatement preparador2 = con.prepareStatement(lastId);
					ResultSet resultado = preparador2.executeQuery())
			{
				if (resultado.next())
				{
					user.setId(resultado.getInt(1));
				}
			}
			return true;
		}
	}

	public static boolean alterar(Usuario user) throws SQLException, ClassNotFoundException
	{
		String sql = "UPDATE usuario SET nome = ?, cpf = ?, idEmpresa = ?, expediente = ?, "
				+ "livreAcesso = ?, alteraAr = ?, usuario = ?, senha = ? WHERE idUsuario = ?";

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement preparador = con.prepareStatement(sql))
		{
			preparador.setString(1, user.getNome());
			preparador.setLong(2, user.getCpf());

			if (user.getIdEmpresa() == 0)
				preparador.setNull(3, java.sql.Types.INTEGER);
			else
				preparador.setInt(3, user.getIdEmpresa());

			preparador.setString(4, user.getExpediente());
			preparador.setBoolean(5, user.getLivreAcesso());
			preparador.setBoolean(6, user.getAlteraAr());
			preparador.setString(7, user.getUsuario());
			preparador.setString(8, user.getSenha());
			preparador.setInt(9, user.getId());

			preparador.execute();
			return true;
		}
	}

	public static boolean excluir(Usuario user) throws SQLException, ClassNotFoundException
	{
		String sql = "DELETE FROM usuario WHERE idUsuario = ?";

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement preparador = con.prepareStatement(sql))
		{
			preparador.setInt(1, user.getId());
			int resultado = preparador.executeUpdate();

			return resultado == 1;
		}
	}
	
	public static ArrayList<Usuario> consultar(String nome) throws ClassNotFoundException, SQLException
	{
		nome = nome == null ? "" : nome;
		Usuario usuario;
		ArrayList<Usuario> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM usuario WHERE UPPER(nome) LIKE ?";
		
		try(Connection con = ConnectionFactory.getConnection();
				PreparedStatement preparador = con.prepareStatement(sql))
		{
			preparador.setString(1, "%" + nome.toUpperCase() + "%");
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next())
			{
				usuario = new Usuario();
				
				usuario.setId(resultado.getInt("idUsuario"));
				usuario.setTipo(resultado.getInt("tipo"));
				usuario.setNome(resultado.getString("Nome"));
				usuario.setCpf(resultado.getLong("cpf"));
				usuario.setExpediente(resultado.getString("expediente"));
				usuario.setLivreAcesso(resultado.getBoolean("livreAcesso"));
				usuario.setAlteraAr(resultado.getBoolean("alteraAr"));
				usuario.setUsuario(resultado.getString("usuario"));
				usuario.setSenha(resultado.getString("senha"));
				
				lista.add(usuario);
			}
		}
		return lista;
	}
	
	public static boolean validar(Usuario user) throws SQLException, ClassNotFoundException
	{
		String sql = "SELECT usuario, senha FROM usuario WHERE usuario = ? and senha= ?";

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement preparador = con.prepareStatement(sql))
		{
			preparador.setString(1, user.getUsuario());
			preparador.setString(2, user.getSenha());

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next())
				return true;
		}
		return false;
	}
}
