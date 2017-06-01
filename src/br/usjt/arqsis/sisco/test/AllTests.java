package br.usjt.arqsis.sisco.test;

// O Teste só irá funcionar 1 única vez, porque tanto a classe 'UsuarioTest' como na 'EmpresaTest'
// estão configurado para incluir, pesquisar, alterar, e excluir o ID posterior aos inserts
// realizados no script 'dados.sql', ou seja, ID empresa 3 (pois há 2 empresas a serem cadastrada)
// e ID usuário 6 (pois há 5 usuários a serem cadastrados).
// Ao executar o teste uma segunda vez, o ID da empresa e do usuário serão 4 e 7 respectivamente,
// logo, o teste não irá funcionar, pois o mesmo irá comparar 3 com 4, e 6 com 7.

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses(
{ EmpresaTest.class, UsuarioTest.class })

public class AllTests
{

}