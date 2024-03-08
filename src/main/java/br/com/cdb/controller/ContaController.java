package br.com.cdb.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdb.entity.Conta;
import br.com.cdb.entity.Transferencia;
import br.com.cdb.enums.TipoPagamento;
import br.com.cdb.service.TransferenciaService;
import br.com.cdb.service.impl.ContaServiceImpl;
import br.com.cdb.service.impl.TransferenciaServiceImpl;

@RestController
@RequestMapping("/conta")
public class ContaController {
		
	@Autowired
	ContaServiceImpl contS;
	@Autowired
	TransferenciaService transfS;
	
	@GetMapping("/saldo/{id}")
	public ResponseEntity<Double> mostrarSaldo(@PathVariable long id){
		double saldo;	
		saldo=contS.mostrarSaldo(id);
		return new ResponseEntity(saldo,HttpStatus.OK);
		}
	
	@PostMapping("/add")
	public ResponseEntity<?> addConta(@RequestBody HashMap<String,String> add){
			Conta conta=new Conta();
			String senha=add.get("senha");
			String cpf=add.get("cpf");
			
			conta.setSenha(senha);
			conta.setCpfDoCliente(cpf);
			conta.setAgencia(contS.numeroAgencia());
			conta.setNumeroConta(contS.numerConta());
			contS.addConta(conta);
			
			
			if (senha == null || cpf == null) {
		        return new ResponseEntity("CPF e senha são obrigatórios",HttpStatus.UNAUTHORIZED);
		    }
			
			return new ResponseEntity(conta,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	@PostMapping("/depositar")
	public ResponseEntity<String> depositar(@RequestBody HashMap<String,String> dep){
		try {
		
			double valor=(double) Double.parseDouble(dep.get("valor"));
			int numeroConta=(int) Integer.parseInt(dep.get("numeroConta"));
			
			if(valor<0) {
			throw new RuntimeException("O valor do deposito deve ser positivo");
		}
		
		
		contS.depositar(valor, numeroConta);
		
		return new ResponseEntity("Deposito realizado",HttpStatus.OK);
	
		
		}catch(Exception e) {
			return new ResponseEntity("Falha ao realizar deposito", HttpStatus.UNAUTHORIZED);
		}
		}

	@PostMapping("/pix")
	public ResponseEntity<String> TransferenciaPix(@RequestBody HashMap<String, String> conta){
        try {                                           

	long idContaOrigem=(long) Long.parseLong(conta.get("idContaOrigem"));
	String cpfDestino=conta.get("cpfDestino");
	double valor=(double) Double.parseDouble(conta.get("valor"));
	
	contS.transferenciaPix(idContaOrigem,cpfDestino,valor,TipoPagamento.PIX);
	Conta conta1 =contS.contaPorId(idContaOrigem);
	Conta conta2=contS.getCpf(cpfDestino);
	Transferencia transf = new Transferencia(conta1.getNumeroConta(),conta2.getNumeroConta(),valor,TipoPagamento.PIX);
	transfS.salvar(transf);
	if(valor<0) {
		throw new RuntimeException("O valor da transferencia deve ser positivo");
		}
	
	
	
	return new ResponseEntity("Transferencia realizado",HttpStatus.OK);
	
	
	}catch(Exception e) {
		e.getMessage();
		return new ResponseEntity("Falha ao realizar a transferencia", HttpStatus.UNAUTHORIZED);
	}
	}

	@PostMapping("/ted")
	public ResponseEntity<String> TransferenciaTed(@RequestBody HashMap<String,String> ted){                                          
	
	
	int agencia=(int) Integer.parseInt(ted.get("agencia"));
	int numeroConta=(int) Integer.parseInt(ted.get("numeroConta"));
	double valor=(double) Double.parseDouble(ted.get("valor"));
	
	long id=(long) Long.parseLong(ted.get("id"));
	contS.transferenciaTed(agencia, numeroConta, valor, TipoPagamento.TED,id);
	Conta conta =contS.contaPorId(id);
	Transferencia transf = new Transferencia(conta.getNumeroConta(),numeroConta,valor,TipoPagamento.TED);
	transfS.salvar(transf);
	if(valor<0) {
		throw new RuntimeException("O valor da transferencia deve ser positivo");
	}
	
	
	return new ResponseEntity("Transferencia realizado",HttpStatus.OK);

	
	
	}






}






