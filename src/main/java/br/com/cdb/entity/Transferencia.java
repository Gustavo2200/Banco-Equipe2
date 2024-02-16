package br.com.cdb.entity;

public class Transferencia {

	private int pessoa1;
	
	private int pessoa2;
	
	private int valor;

	
	public void Trasferencia(int pessoa1, int pessoa2, int valor) {
		this.pessoa1=pessoa1;
		this.pessoa2=pessoa2;
		this.valor=valor;
	}
	
	public void transferir(Conta contaOrigem, Conta contaDestino) {
		if(contaOrigem.getSaldo()>=valor) {
			contaOrigem.setSaldo(contaOrigem.getSaldo()-valor);
			contaOrigem.setSaldo(contaOrigem.getSaldo()+valor);
			System.out.println("Transferência de"+ valor +"realizada com sucesso ");
		}else {
			System.out.println("Saldo insuficiente");
		}
	
		
		
		
	}
	
	
	
	
	public int getPessoa1() {
		return pessoa1;
	}

	public void setPessoa1(int pessoa1) {
		this.pessoa1 = pessoa1;
	}

	public int getPessoa2() {
		return pessoa2;
	}

	public void setPessoa2(int pessoa2) {
		this.pessoa2 = pessoa2;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	




}
