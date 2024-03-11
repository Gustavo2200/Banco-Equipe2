package br.com.cdb.entity.dto;

import br.com.cdb.enums.TipoPagamento;

public class TransferenciaDto{

	private int contaOrigem;
	private int contaDestino;
	private double valor;
	private int id;
	private TipoPagamento tipoTransferencia;
	
	public int getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(int contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	public int getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(int contaDestino) {
		this.contaDestino = contaDestino;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoPagamento getTipoTransferencia() {
		return tipoTransferencia;
	}
	public void setTipoTransferencia(TipoPagamento tipoTransferencia) {
		this.tipoTransferencia = tipoTransferencia;
	}
}
