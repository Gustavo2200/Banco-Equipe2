package br.com.cdb.dao.impl;
import br.com.cdb.dao.InterfacePagamento;
import br.com.cdb.enums.TipoPagamento;

public class TipoPagamentoImpl implements InterfacePagamento{

	public void finalizar(TipoPagamento pagamento) {
		System.out.println("Compra realizada com sucesso");
		
		
	}

}
