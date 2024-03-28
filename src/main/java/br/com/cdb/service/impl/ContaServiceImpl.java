package br.com.cdb.service.impl;

import br.com.cdb.service.ClienteService;
import br.com.cdb.service.ContaService;
import br.com.cdb.dao.ContaDao;
import br.com.cdb.entity.Cliente;
import br.com.cdb.entity.Conta;


import br.com.cdb.enums.TipoPagamento;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class ContaServiceImpl implements ContaService {
	@Qualifier("ContaDaoJDBC")
	@Autowired
	
	ContaDao contaDao;
	Random random = new Random();
	
	@Override
	public int numeroAgencia() {
		Random random = new Random();
		int numeroAle = random.nextInt(9000) + 1000;

		return numeroAle;
	}

	@Override
	public int numerConta() {
		Random random = new Random();
		int numeroAlea = random.nextInt(90000000) + 10000000;

		return numeroAlea;
	}

	
	public boolean transferenciaPix(long idContaOrigem, String cpfDestino, double valor, TipoPagamento tipo) {
		if(valorPositivo(valor)) {
		return contaDao.transferenciaPix(idContaOrigem, cpfDestino, valor, tipo);
		}else {
			throw new RuntimeException("O valor da transferencia deve ser positivo");
		}

	}
	
	@Override
	public double mostrarSaldo(long id) {
		return contaDao.contaPorId(id).getSaldo();
	}

	

	@Override
	public boolean transferenciaTed(int agencia, int numeroConta, double valor, TipoPagamento tipo, long id) {
		if(valorPositivo(valor)) {
		return contaDao.transferenciaTed(agencia, numeroConta, valor, tipo, id);
		}else {
			throw new RuntimeException("O valor da transferencia deve ser positivo");
		}
	}

	@Override
	public void addConta(Conta conta) {
	    String cpf = conta.getCpfDoCliente();
	    String senha = conta.getSenha();

	    if (existeContaComCpf(cpf)) {
	        throw new RuntimeException("CPF já cadastrado");
	    }

	    if (existeContaComSenha(senha)) {
	        throw new RuntimeException("Senha já cadastrada");
	    }
	    

	    contaDao.addConta(conta);
	}

	@Override
	public Conta getCpf(String cpf) {
	return contaDao.getCpf(cpf);
	
	}


	@Override
	public List<Conta> listar() {
		
		return contaDao.listar();
	}


	@Override
	public void depositar(double valor, int numeroConta) {
		if(valorPositivo(valor)) {
		contaDao.depositar(valor, numeroConta);
		}else {
			throw new RuntimeException("O valor do deposito deve ser positivo");
		}
	}


	
	@Override
	public String validacaoSenha(String senha) {
		String regex = "^.{4,}$";
		if (senha.matches(regex)) {
			return senha;
		} else {
			throw new RuntimeException("Erro, senha inválida!");
		}
	}


	@Override
	public boolean valorPositivo(double valor) {
		
		return valor>0;
	}


	@Override
	public boolean getAgencia(int agencia) {
		
		return contaDao.getAgencia(agencia);
	}


	@Override
	public boolean getNumero(int numero) {
		
			return contaDao.getNumero(numero);
		
	}


	@Override
	public Conta contaPorId(Long id) {
		return contaDao.contaPorId(id);
	}

	public boolean existeContaComSenha(String senha) {
	    for (Conta conta : contaDao.listar()) {
	        if (conta.getSenha() != null && conta.getSenha().equals(senha)) {
	            return true;
	        }
	    }
	    return false;
	}

	public boolean existeContaComCpf(String cpf) {
	    for (Conta conta : contaDao.listar()) {
	        if (conta.getCpfDoCliente() != null && conta.getCpfDoCliente().equals(cpf)) {
	            return true;
	        }
	    }
	    return false;
	}

	
}
