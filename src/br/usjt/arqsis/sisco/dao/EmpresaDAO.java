package br.usjt.arqsis.sisco.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.usjt.arqsis.sisco.dao.ConnectionFactory;
import br.usjt.arqsis.sisco.model.Empresa;

public class EmpresaDAO
{
	public static Empresa consultar(int id) throws SQLException, ClassNotFoundException
	{
		Empresa emp = new Empresa();
		emp.setId(id);

		String sql = "SELECT razaoSocial, cnpj, conjuntoOcupado, horarioFuncionamento, "
				+ "horarioAr, temperaturaAr FROM empresa WHERE idEmpresa = ?";

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement preparador = con.prepareStatement(sql))
		{
			preparador.setInt(1, emp.getId());

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next())
			{
				String razaoSocial = resultado.getString("razaoSocial");
				long cnpj = resultado.getLong("cnpj");
				int conjuntoOcupado = resultado.getInt("conjuntoOcupado");
				String hrFunc = resultado.getString("horarioFuncionamento");
				String hrAr = resultado.getString("horarioAr");
				int temperaturaAr = resultado.getInt("temperaturaAr");

				emp.setRazaoSocial(razaoSocial);
				emp.setCnpj(cnpj);
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
		String sql = "INSERT INTO empresa (razaoSocial, cnpj, conjuntoOcupado, horarioFuncionamento, "
				+ "horarioAr, temperaturaAr) VALUES(?, ?, ?, ?, ?, ?)";

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement preparador = con.prepareStatement(sql))
		{
			int hrFuncionamento = Integer.parseInt(emp.getHorarioDeFuncionamento());
			int hrAr = Integer.parseInt(emp.getHorarioDoAr());

			preparador.setString(1, emp.getRazaoSocial());
			preparador.setLong(2, emp.getCnpj());
			preparador.setInt(3, emp.getConjunto());
			preparador.setInt(4, hrFuncionamento);
			preparador.setInt(5, hrAr);
			preparador.setInt(6, emp.getTemperatura());
			preparador.execute();

			String lastId = "SELECT LAST_INSERT_ID()";

			try (PreparedStatement preparador2 = con.prepareStatement(lastId);
					ResultSet resultado = preparador2.executeQuery())
			{
				if (resultado.next())
				{
					emp.setId(resultado.getInt(1));
				}
			}
			return true;
		}
	}

	public static boolean alterar(Empresa emp) throws SQLException, ClassNotFoundException
	{
		String sql = "UPDATE empresa SET razaoSocial = ?, cnpj = ?, conjuntoOcupado = ?, "
				+ "horarioFuncionamento = ?, horarioAr = ?, temperaturaAr = ? WHERE idEmpresa = ?";

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement preparador = con.prepareStatement(sql))
		{
			int hrFuncionamento = Integer.parseInt(emp.getHorarioDeFuncionamento());
			int hrAr = Integer.parseInt(emp.getHorarioDoAr());

			preparador.setString(1, emp.getRazaoSocial());
			preparador.setLong(2, emp.getCnpj());
			preparador.setInt(3, emp.getConjunto());
			preparador.setInt(4, hrFuncionamento);
			preparador.setInt(5, hrAr);
			preparador.setInt(6, emp.getTemperatura());
			preparador.setInt(7, emp.getId());

			preparador.execute();
			return true;
		}
	}

	public static boolean excluir(Empresa emp) throws SQLException, ClassNotFoundException
	{
		String sql1 = "DELETE FROM usuario WHERE idEmpresa = ?;";
		String sql2 = "DELETE FROM empresa WHERE idEmpresa = ?;";

		try (Connection con = ConnectionFactory.getConnection();
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