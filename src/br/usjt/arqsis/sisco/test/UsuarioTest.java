package br.usjt.arqsis.sisco.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.*;
import org.junit.runners.MethodSorters;

import br.usjt.arqsis.sisco.model.Usuario;
import br.usjt.arqsis.sisco.service.UsuarioService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UsuarioTest
{
	@Test
	public void test01_cadastrar() throws ClassNotFoundException, SQLException
	{
		Usuario user = new Usuario(0, 2, "Testando Teste", 11111111111L, 0, "00:00 - 11:59", true, true, "teste", "teste");

		boolean ok = UsuarioService.cadastrar(user);

		assertTrue(ok);
	}

	@Test
	public void test02_consultar() throws ClassNotFoundException, SQLException
	{
		Usuario user1 = new Usuario(6, 2, "Testando Teste", 11111111111L, 0, "00:00 - 11:59", true, true, "teste", "teste");

		// ID 6 porque no script 'dados.sql' há 5 usuários para inclusão
		Usuario user2 = UsuarioService.consultar(6);

		boolean ok = user1.toString().equals(user2.toString());

		assertTrue(ok);
	}

	@Test
	public void test03_alterar() throws ClassNotFoundException, SQLException
	{
		Usuario user = UsuarioService.consultar(6);
		user.setCpf(10101010101L);
		user.setNome("Teste Testado");

		boolean ok = UsuarioService.alterar(user);

		assertTrue(ok);
	}

	@Test
	public void test04_excluir() throws ClassNotFoundException, SQLException
	{
		Usuario user = UsuarioService.consultar(6);
		boolean ok = UsuarioService.excluir(user);

		assertTrue(ok);
	}

}
