package br.com.cdb.Dao.impl;
import br.com.cdb.Dao.InterfacePagamento;
import br.com.cdb.enums.TipoPagamento;

public class TipoPagamentoImpl implements InterfacePagamento{

	public void finalizar(TipoPagamento pagamento) {
		System.out.println("Compra realizada com sucesso");
		
		
	}

}
