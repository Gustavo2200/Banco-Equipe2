//package br.com.cdb.dao.impl3;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Repository;
//
//import br.com.cdb.dao.ContaDao;
//import br.com.cdb.dao.repository.ContaRepository;
//import br.com.cdb.entity.Conta;
//import br.com.cdb.enums.TipoPagamento;
//import br.com.cdb.exception.BancoException;
//
//public class ContaDaoImpl3 implements ContaDao{
//	@Autowired
//	ContaRepository contaRepository;
//	
//
//	@Override
//	public List<Conta> listar() {
//		return contaRepository.findAll();
//	}
//
//	@Override
//	public void depositar(double valor, int numeroConta) {
//
//		for(Conta conta : contaRepository.findAll()) {
//			if(conta.getNumeroConta()==numeroConta) {
//				conta.setSaldo(valor+conta.getSaldo());
//				contaRepository.save(conta);
//				break;
//			}
//		}
//	}
//
//	@Override
//	public Conta contaPorId(Long id) {
//	return contaRepository.findById(id).get();
//	}
//
//	@Override
//	public Conta getCpf(String cpf) {
//		for(Conta conta : contaRepository.findAll()) {
//			if(conta.getCpfDoCliente().equals(cpf)) {
//				return conta;
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public void addConta(Conta conta) {
//		contaRepository.save(conta);
//		
//	}
//
//	@Override
//	public boolean transferenciaPix(long idContaOrigem, String cpfDestino, double valor, TipoPagamento tipo) {
//		Conta c1= contaRepository.findById(idContaOrigem).get();
//		Conta c2= getCpf(cpfDestino);
//		if(c1==null||c2==null) {
//			throw new BancoException(HttpStatus.BAD_REQUEST,"Não foi encontrado");
//		}
//		else {
//			c1.setSaldo(c1.getSaldo()-valor);
//			c2.setSaldo(c2.getSaldo()+valor);
//			contaRepository.save(c1);
//			contaRepository.save(c2);
//			return true;
//		}
//	}
//
//	@Override
//	public boolean transferenciaTed(int agencia, int numeroConta, double valor, TipoPagamento tipo, long id) {
//		Conta c1 = contaRepository.findById(id).get();
//	
//		for(Conta conta : contaRepository.findAll()) {
//			if(agencia==conta.getAgencia() && numeroConta==conta.getNumeroConta()) {
//					 c1.setSaldo(c1.getSaldo()-valor);
//					 conta.setSaldo(conta.getSaldo()+valor);
//					 contaRepository.save(c1);
//					 contaRepository.save(conta);
//					 return true;
//			}
//		}
//		throw new BancoException(HttpStatus.BAD_REQUEST,"Não foi encontrado");
//	}
//
//	@Override
//	public boolean getAgencia(int agencia) {
//		for(Conta conta : contaRepository.findAll()) {
//			if(conta.getAgencia()==agencia) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	@Override
//	public boolean getNumero(int numero) {
//		for(Conta conta:contaRepository.findAll()) {
//			if(conta.getNumeroConta()==numero) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	
//}
