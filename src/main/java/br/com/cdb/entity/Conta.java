package br.com.cdb.entity;

public class Conta {
private int tipoConta;
private String senha;
private double saldo;
private int numeroConta;
private long id;

public Conta() {}

public int getTipoConta() {
	return tipoConta;
}
public void setTipoConta(int tipoConta) {
	this.tipoConta = tipoConta;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
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
