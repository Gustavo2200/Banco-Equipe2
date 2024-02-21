package br.com.cdb.view;

import br.com.cdb.dao.ContaDao;
import br.com.cdb.dao.impl.ContaDaoImpl;
import br.com.cdb.entity.Conta;
import br.com.cdb.enums.TipoConta;
import br.com.cdb.enums.TipoPagamento;
import br.com.cdb.service.ContaService;
import br.com.cdb.service.impl.ContaServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		ContaDao contaD = new ContaDaoImpl();
		ContaService contaS = new ContaServiceImpl(contaD);
		Conta conta = new Conta();
		Conta conta2 = new Conta();
		
		
		conta.setTipoConta(TipoConta.CONTA_CORRENTE);
		
		conta.setCpfDoCliente("12345678901");
		conta.setNumeroConta(contaS.numerConta());
		conta.setSaldo(100);
		conta.setSenha("12345678");
		conta.setAgencia(contaS.numeroAgencia());
		
		conta2.setAgencia(contaS.numeroAgencia());
		conta2.setCpfDoCliente("12345678900");
		conta2.setNumeroConta(contaS.numerConta());
		conta2.setSaldo(0);
		conta2.setSenha("12345677");
		conta2.setTipoConta(TipoConta.CONTA_POUPANCA);
		
		
		contaS.addConta(conta);
		contaS.addConta(conta2);
		
		contaS.transferenciaTed(conta.getAgencia(), conta2.getNumeroConta(), 20, TipoPagamento.TED);
		
		System.out.println(contaS.mostrarSaldo(conta.getId()));
		System.out.println(contaS.mostrarSaldo(conta2.getId()));
		
		contaS.transferenciaPix(conta.getId(), conta2.getCpfDoCliente(), 10, TipoPagamento.PIX);

		System.out.println(contaS.mostrarSaldo(conta.getId()));
		System.out.println(contaS.mostrarSaldo(conta2.getId()));
		
		
		
		
		
		
	}
}
