package br.usjt.arq.sisco.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.*;
import org.junit.runners.MethodSorters;

import br.usjt.arq.sisco.model.Usuario;
import br.usjt.arq.sisco.service.UsuarioService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UsuarioTest
{
	@Test
	public void test01_cadastrar() throws ClassNotFoundException, SQLException
	{
		Usuario user = new Usuario(2, "Síndico Prédio", 11111111111L,
				0, "00001159", true, true, "sindico", "sindico");
		
		boolean ok = UsuarioService.cadastrar(user);
		
		assertTrue(ok);
	}
	
	@Test
	public void test02_consultar() throws ClassNotFoundException, SQLException
	{
		Usuario user1 = new Usuario(2, "Síndico Prédio", 11111111111L,
				0, "00001159", true, true, "sindico", "sindico");
		
		Usuario user2 = UsuarioService.consultar(11111111111L);
		
		boolean ok = user1.toString().equals(user2.toString());
		
		assertTrue(ok);
	}
	
	@Test
	public void test03_alterar() throws ClassNotFoundException, SQLException
	{
		Usuario user = UsuarioService.consultar(11111111111L);
		user.setCpf(10101010101L);
		user.setNome("Síndico Silva");
		
		boolean ok = UsuarioService.alterar(user);

		assertTrue(ok);
	}
	
	@Test
	public void test04_excluir() throws ClassNotFoundException, SQLException
	{
		Usuario user = UsuarioService.consultar(10101010101L);
		boolean ok = UsuarioService.excluir(user);
		
		assertTrue(ok);
	}

}
