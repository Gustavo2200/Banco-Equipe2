package br.com.cdb.entity;

import br.com.cdb.enums.TipoPagamento;

public class Transferencia {

	private int pessoa1;

	private int pessoa2;

	private double valor;

	private int id;
	
	TipoPagamento tipo;
	
	public Transferencia(int pessoa1, int pessoa2, double valor, TipoPagamento tipo) {
		this.pessoa1=pessoa1;
		this.pessoa2=pessoa2;
		this.valor=valor;
		this.tipo=tipo;
	}
	
	public void transferir(Conta contaOrigem, Conta contaDestino, double valor) {
		if (contaOrigem.getSaldo() >= valor) {
			contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
			contaDestino.setSaldo(contaDestino.getSaldo() + valor);
			
		} else {
			
			throw new RuntimeException("Saldo insuficiente");
		}
		
	}
	 @Override
	    public String toString(){
	        return "Conta Origem: " +pessoa1 + "\nConta Destino: " + pessoa2
	                + "\nValor: " + valor + "\nTipo de Transação: " + tipo.getDescricao() + "\n\n";
	    }
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
