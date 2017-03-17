package br.usjt.arq.sisco.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.usjt.arq.sisco.dao.DriverConexao;
import br.usjt.arq.sisco.model.Empresa;

public class EmpresaDAO
{
	public static Empresa consultar(long cnpj) throws SQLException, ClassNotFoundException
	{
		Empresa emp = new Empresa();
		emp.setCnpj(cnpj);
		
		String sql = "SELECT idEmpresa, razaoSocial, conjuntoOcupado, horarioFuncionamento, " +
		"horarioAr, temperaturaAr FROM empresa WHERE cnpj = ?";

		try(Connection con = DriverConexao.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql))
		{
			preparador.setLong(1, emp.getCnpj());

			ResultSet resultado = preparador.executeQuery();

			if(resultado.next())
			{
				int		id =				resultado.getInt("idEmpresa");
				String	razaoSocial =		resultado.getString("razaoSocial");
				short	conjuntoOcupado =	resultado.getShort("conjuntoOcupado");
				String	hrFunc =			resultado.getString("horarioFuncionamento");
				String	hrAr =				resultado.getString("horarioAr");
				byte	temperaturaAr = 	resultado.getByte("temperaturaAr");

				emp.setId(id);
				emp.setRazaoSocial(razaoSocial);
				emp.setConjunto(conjuntoOcupado);
				emp.setHorarioDeFuncionamento(hrFunc);
				emp.setHorarioDoAr(hrAr);
				emp.setTemperatura(temperaturaAr);
			}
		}
		return emp;
	}

	public static boolean cadastrar(Empresa emp) throws SQLException, ClassNotFoundException
	{
		String sql = "INSERT INTO empresa (razaoSocial, cnpj, conjuntoOcupado, horarioFuncionamento, horarioAr, temperaturaAr) VALUES(?, ?, ?, ?, ?, ?)";

		try(Connection con = DriverConexao.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql))
		{
			int hrFuncionamento	= Integer.parseInt(emp.getHorarioDeFuncionamento());
			int hrAr			= Integer.parseInt(emp.getHorarioDoAr());

			preparador.setString(1, emp.getRazaoSocial());
			preparador.setLong(2, emp.getCnpj());
			preparador.setInt(3, emp.getConjunto());
			preparador.setInt(4, hrFuncionamento);
			preparador.setInt(5, hrAr);
			preparador.setByte(6, emp.getTemperatura());
			preparador.execute();
			
			String lastId = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement preparador2 = con.prepareStatement(lastId);
					ResultSet resultado = preparador2.executeQuery())
			{
				if(resultado.next())
				{
					emp.setId(resultado.getInt(1));
				}
			}
			return true;
		}
	}

	public static boolean alterar(Empresa emp) throws SQLException, ClassNotFoundException
	{
		String	sql = "UPDATE empresa SET razaoSocial = ?, cnpj = ?, conjuntoOcupado = ?, " +
					   "horarioFuncionamento = ?, horarioAr = ?, temperaturaAr = ? WHERE idEmpresa = ?";

		try(Connection con = DriverConexao.getConnection();
			PreparedStatement preparador = con.prepareStatement(sql))
		{
			int hrFuncionamento	= Integer.parseInt(emp.getHorarioDeFuncionamento());
			int hrAr			= Integer.parseInt(emp.getHorarioDoAr());

			preparador.setString(1, emp.getRazaoSocial());
			preparador.setLong(2, emp.getCnpj());
			preparador.setInt(3, emp.getConjunto());
			preparador.setInt(4, hrFuncionamento);
			preparador.setInt(5, hrAr);
			preparador.setByte(6, emp.getTemperatura());
			preparador.setInt(7, emp.getId());
			
			preparador.execute();
			return true;
		}
	}

	public static boolean excluir(Empresa emp) throws SQLException, ClassNotFoundException
	{
		String sql1 = "DELETE FROM usuario WHERE idEmpresa = ?;";
		String sql2 = "DELETE FROM empresa WHERE idEmpresa = ?;";

		try(Connection con = DriverConexao.getConnection();
			PreparedStatement preparador1 = con.prepareStatement(sql1);
			PreparedStatement preparador2 = con.prepareStatement(sql2))
		{
			preparador1.setLong(1, emp.getId());
			preparador1.executeUpdate();
			
			preparador2.setLong(1, emp.getId());
			int resultado = preparador2.executeUpdate();
			
			return resultado == 1;
		}
	}

}