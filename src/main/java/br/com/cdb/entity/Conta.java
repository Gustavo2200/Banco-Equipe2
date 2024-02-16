package br.com.cdb.entity;

import br.com.cdb.enums.TipoConta;

public class Conta {

	private TipoConta tipoConta;
	private String senha;
	private double saldo;
	private int numeroConta;
	private int agencia;
	private long id;
	private String cpfDoCliente;

	public Conta() {
	}

	public Conta(TipoConta tipoConta, String senha, double saldo, int numeroConta, 
			int agencia, long id, String cpfDoCliente) {
		this.tipoConta = tipoConta;
		this.senha = senha;
		this.saldo = saldo;
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.id = id;
		this.cpfDoCliente = cpfDoCliente;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public String getCpfDoCliente() {
		return cpfDoCliente;
	}

	public void setCpfDoCliente(String cpfDoCliente) {
		String regex = "^[0-9]{3}[0-9]{3}[0-9]{3}[0-9]{2}$";
		if (cpfDoCliente.matches(regex)) {
			this.cpfDoCliente = cpfDoCliente;
		} else {
			throw new RuntimeException("Erro, cpf inválido!");
		}

	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		String regex = "^.{8,}$";
		if (senha.matches(regex)) {
			this.senha = senha;
		} else {
			throw new RuntimeException("Erro, senha inválida!");
		}

	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
