package br.com.cdb.enums;
public enum TipoPagamento {
	CARTAO_CREDITO(0),
	CARTAO_DEBITO(1),
	PIX(2),
	TED(3);
	
	private int tipoPagamento;
	
	private TipoPagamento(int tipoPagamento) {this.tipoPagamento = tipoPagamento;}

	public int getTipoPagamento() {
		return tipoPagamento;
	}

}
