package br.com.cdb.enums;

public enum TipoConta {

	
	CONTA_CORRENTE(0),
	CONTA_POUPANCA(1);
	private int tipoConta;
	private TipoConta(int tipoConta) {
		this.tipoConta=tipoConta;
	}
	public int getTipoConta() {
		return tipoConta;
	}
	
}
