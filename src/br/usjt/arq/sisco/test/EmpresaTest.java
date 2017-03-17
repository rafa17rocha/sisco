package br.usjt.arq.sisco.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.*;
import org.junit.runners.MethodSorters;

import br.usjt.arq.sisco.model.Empresa;
import br.usjt.arq.sisco.service.EmpresaService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class EmpresaTest
{
	
	@Test
	public void test01_cadastrar() throws ClassNotFoundException, SQLException
	{
		Empresa emp = new Empresa("IBM", 33333333333333L, (short) 32, "09302230", "10001300", (byte) 21);
		boolean ok = EmpresaService.cadastrar(emp);
		
		assertTrue(ok);
	}
	
	@Test
	public void test02_consultar() throws ClassNotFoundException, SQLException
	{
		Empresa emp1 = new Empresa("IBM", 33333333333333L, (short) 32, "09302230", "10001300", (byte) 21);
		Empresa emp2 = EmpresaService.consultar(33333333333333L);
		
		assertTrue(emp1.toString().equals(emp2.toString()));
	}
	
	@Test
	public void test03_alterar() throws ClassNotFoundException, SQLException
	{
		Empresa emp = EmpresaService.consultar(33333333333333L);
		emp.setCnpj(30303030303030L);
		emp.setRazaoSocial("IBM Corp.");
		emp.setTemperatura((byte) 25); 
		
		boolean ok = EmpresaService.alterar(emp);

		assertTrue(ok);
	}
	
	@Test
	public void test04_excluir() throws ClassNotFoundException, SQLException
	{
		Empresa emp = EmpresaService.consultar(30303030303030L);
		boolean ok = EmpresaService.excluir(emp);
		
		assertTrue(ok);
	}

}
