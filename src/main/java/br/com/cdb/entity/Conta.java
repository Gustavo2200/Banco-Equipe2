package br.com.cdb.entity;



public class Conta {

	
	private String senha;
	private double saldo;
	private int numeroConta;
	private int agencia;
	private long id;
	private String cpfDoCliente;

	public Conta() {
	}

	public Conta(String senha, double saldo, int numeroConta, 
			int agencia, String cpfDoCliente) {
		
		this.senha = senha;
		this.saldo = saldo;
		this.numeroConta = numeroConta;
		this.agencia = agencia;
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
		this.cpfDoCliente=cpfDoCliente;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha=senha;

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
