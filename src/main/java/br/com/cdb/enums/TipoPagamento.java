package br.com.cdb.enums;
public enum TipoPagamento {
	PIX(0,"PIX"),
	TED(1,"TED");
	
	private int tipoPagamento;
	private String descricao;
	
	private TipoPagamento(int tipoPagamento,String descricao) {
		this.tipoPagamento = tipoPagamento;
		this.descricao = descricao;
		}

	public int getTipoPagamento() {
		return tipoPagamento;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
