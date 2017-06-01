package br.usjt.arqsis.sisco.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.*;
import org.junit.runners.MethodSorters;

import br.usjt.arqsis.sisco.model.Empresa;
import br.usjt.arqsis.sisco.service.EmpresaService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EmpresaTest
{

	@Test
	public void test01_cadastrar() throws ClassNotFoundException, SQLException
	{
		Empresa emp = new Empresa(3, "IBM", 33333333333333L, 32, "09:30 - 22:30", "10:00 - 13:00", 21);
		boolean ok = EmpresaService.cadastrar(emp);

		assertTrue(ok);
	}

	@Test
	public void test02_consultar() throws ClassNotFoundException, SQLException
	{
		Empresa emp1 = new Empresa(3, "IBM", 33333333333333L, 32, "09:30 - 22:30", "10:00 - 13:00", 21);
		
		// ID 3 porque no script 'dados.sql' há 2 empresas para inclusão
		Empresa emp2 = EmpresaService.consultar(3);

		assertTrue(emp1.toString().equals(emp2.toString()));
	}

	@Test
	public void test03_alterar() throws ClassNotFoundException, SQLException
	{
		Empresa emp = EmpresaService.consultar(3);
		emp.setCnpj(30303030303030L);
		emp.setRazaoSocial("IBM Corp.");
		emp.setTemperatura(25);

		boolean ok = EmpresaService.alterar(emp);

		assertTrue(ok);
	}

	@Test
	public void test04_excluir() throws ClassNotFoundException, SQLException
	{
		Empresa emp = EmpresaService.consultar(3);
		boolean ok = EmpresaService.excluir(emp);

		assertTrue(ok);
	}

}
