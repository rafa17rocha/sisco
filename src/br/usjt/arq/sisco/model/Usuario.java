package br.usjt.arq.sisco.model;

import java.io.Serializable;

public class Usuario implements Serializable
{
	private static final long	serialVersionUID = 1L;
	private int					id;
	private int					tipo;
	private String				nome;
	private long				cpf;
	private int					idEmpresa;
	private String				expediente;
	private boolean				livreAcessoCatraca;
	private boolean				alteraArEmpresa;
	private String				usuario;
	private String				senha;
	
	public Usuario(){}
	
	public Usuario(int tipo, String nome, long cpf, int idEmpresa, String expediente,
			boolean livreAcessoCatraca, boolean alteraArEmpresa, String usuario, String senha)
	{
		setTipo(tipo);
		setNome(nome);
		setCpf(cpf);
		setIdEmpresa(idEmpresa);
		setExpediente(expediente);
		setLivreAcesso(livreAcessoCatraca);
		setAlteraAr(alteraArEmpresa);
		setUsuario(usuario);
		setSenha(senha);
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setTipo(int tipo)
	{
		this.tipo = tipo;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public void setIdEmpresa(int idEmpresa)
	{
		this.idEmpresa = idEmpresa;
	}

	public void setCpf(long cpf)
	{
		this.cpf = cpf;
	}

	public void setExpediente(String expediente)
	{
		this.expediente = expediente;
	}

	public void setLivreAcesso(boolean acesso)
	{
		livreAcessoCatraca = acesso;
	}

	public void setAlteraAr(boolean altera)
	{
		alteraArEmpresa = altera;
	}

	public void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}
	
	public int getId()
	{
		return id;
	}

	public int getTipo()
	{
		return tipo;
	}

	public String getNome()
	{
		return nome;
	}

	public long getCpf()
	{
		return cpf;
	}

	public int getIdEmpresa()
	{
		return idEmpresa;
	}

	public String getExpediente()
	{
		return expediente;
	}

	public boolean getLivreAcessoCatraca()
	{
		return livreAcessoCatraca;
	}
	
	public boolean getAlteraAr()
	{
		return alteraArEmpresa;
	}

	public String getUsuario()
	{
		return usuario;
	}

	public String getSenha()
	{
		return senha;
	}

	@Override
	public String toString()
	{
		return "Usuario [getTipo()=" + getTipo() + ", getNome()=" + getNome() + ", getCpf()="
				+ getCpf() + ", getIdEmpresa()=" + getIdEmpresa() + ", getExpediente()=" + getExpediente()
				+ ", getLivreAcessoCatraca()=" + getLivreAcessoCatraca() + ", getAlteraAr()=" + getAlteraAr()
				+ ", getUsuario()=" + getUsuario() + ", getSenha()=" + getSenha() + "]";
	}
}
