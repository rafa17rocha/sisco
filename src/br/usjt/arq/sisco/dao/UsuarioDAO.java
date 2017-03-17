package br.usjt.arq.sisco.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.usjt.arq.sisco.dao.DriverConexao;
import br.usjt.arq.sisco.model.Usuario;

public class UsuarioDAO
{
	public static Usuario consultar(long cpf) throws SQLException, ClassNotFoundException
	{
		String sql = "SELECT idUsuario, tipo, nome, idEmpresa, expediente, livreAcesso, " +
		"alteraAr, usuario, senha FROM usuario WHERE cpf = ?";
		
		Usuario user = null;

		try(Connection con = DriverConexao.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql))
		{
			preparador.setLong(1, cpf);

			ResultSet resultado = preparador.executeQuery();

			if(resultado.next())
			{
				user = new Usuario();
				
				int		id = 			resultado.getInt("idUsuario");
				byte	tipo =			resultado.getByte("tipo");
				String	nome =			resultado.getString("nome");
				int		idEmpresa = 	resultado.getInt("idEmpresa");
				String	expediente =	resultado.getString("expediente");
				boolean	livreAcesso = 	resultado.getBoolean("livreAcesso");
				boolean	alteraAr = 		resultado.getBoolean("alteraAr");
				String	usuario =		resultado.getString("usuario");
				String	senha = 		resultado.getString("senha");

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
		String sql = "INSERT INTO usuario (tipo, nome, cpf, idEmpresa, expediente, " +
		"livreAcesso, alteraAr, usuario, senha) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try(Connection con = DriverConexao.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql))
		{
			preparador.setInt(1, user.getTipo());
			preparador.setString(2, user.getNome());
			preparador.setLong(3, user.getCpf());
			
			int idEmpresa = user.getIdEmpresa();
			
			if(idEmpresa == 0)
				preparador.setNull(4, java.sql.Types.INTEGER);
			else
				preparador.setInt(4, idEmpresa);
			
			preparador.setString(5, user.getExpediente());
			preparador.setBoolean(6, user.getLivreAcessoCatraca());
			preparador.setBoolean(7, user.getAlteraAr());
			preparador.setString(8, user.getUsuario());
			preparador.setString(9, user.getSenha());
			preparador.execute();
			
			String lastId = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement preparador2 = con.prepareStatement(lastId);
					ResultSet resultado = preparador2.executeQuery())
			{
				if(resultado.next())
				{
					user.setId(resultado.getInt(1));
				}
			}
			return true;
		}
	}

	public static boolean alterar(Usuario user) throws SQLException, ClassNotFoundException
	{
		String sql = "UPDATE usuario SET nome = ?, cpf = ?, idEmpresa = ?, expediente = ?, " +
		"livreAcesso = ?, alteraAr = ?, usuario = ?, senha = ? WHERE idUsuario = ?";

		try(Connection con = DriverConexao.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql))
		{
			preparador.setString(1, user.getNome());
			preparador.setLong(2, user.getCpf());
			
			if(user.getIdEmpresa() == 0)
				preparador.setNull(3, java.sql.Types.INTEGER);
			else
				preparador.setLong(3, user.getIdEmpresa());
			
			preparador.setString(4, user.getExpediente());
			preparador.setBoolean(5, user.getLivreAcessoCatraca());
			preparador.setBoolean(6, user.getAlteraAr());
			preparador.setString(7, user.getUsuario());
			preparador.setString(8, user.getSenha());
			preparador.setLong(9, user.getId());
			
			preparador.execute();
			return true;
		}
	}

	public static boolean excluir(Usuario user) throws SQLException, ClassNotFoundException
	{
		String sql = "DELETE FROM usuario WHERE idUsuario = ?";

		try(Connection con = DriverConexao.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql))
		{
			preparador.setLong(1, user.getId());
			int resultado = preparador.executeUpdate();
			
			return resultado == 1;
		}
	}

}
