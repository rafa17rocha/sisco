package br.usjt.arq.sisco.model;

import java.io.Serializable;

public class Empresa implements Serializable
{
	private static final long	serialVersionUID = 1L;
	private int					id;
	private String				razaoSocial;
	private long				cnpj;
	private short				conjunto;
	private String				horarioFuncionamento;
	private String				horarioAr;
	private byte				temperaturaAr;
	
	public Empresa(){};

	public Empresa(String razaoSocial, long cnpj, short conjunto,
			String horarioFuncionamento, String horarioAr, byte temperaturaAr)
	{
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.conjunto = conjunto;
		this.horarioFuncionamento = horarioFuncionamento;
		this.horarioAr = horarioAr;
		this.temperaturaAr = temperaturaAr;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}

	public void setRazaoSocial(String razaoSocial)
	{
		this.razaoSocial = razaoSocial;
	}

	public void setCnpj(long cnpj)
	{
		this.cnpj = cnpj;
	}

	public void setConjunto(short conjunto)
	{
		this.conjunto = conjunto;
	}

	public void setHorarioDeFuncionamento(String horario)
	{
		this.horarioFuncionamento = horario;
	}

	public void setHorarioDoAr(String horario)
	{
		this.horarioAr = horario;
	}

	public void setTemperatura(byte temperatura)
	{
		this.temperaturaAr = temperatura;
	}
	
	public int getId()
	{
		return id;
	}

	public String getRazaoSocial()
	{
		return razaoSocial;
	}

	public long getCnpj()
	{
		return cnpj;
	}

	public short getConjunto()
	{
		return conjunto;
	}

	public String getHorarioDeFuncionamento()
	{
		return horarioFuncionamento;
	}

	public String getHorarioDoAr()
	{
		return horarioAr;
	}

	public byte getTemperatura()
	{
		return temperaturaAr; 
	}

	@Override
	public String toString()
	{
		return "Empresa [getRazaoSocial()=" + getRazaoSocial() + ", getCnpj()=" + getCnpj()
				+ ", getConjunto()=" + getConjunto() + ", getHorarioDeFuncionamento()=" + getHorarioDeFuncionamento()
				+ ", getHorarioDoAr()=" + getHorarioDoAr() + ", getTemperatura()=" + getTemperatura() + "]";
	}
	
	
}