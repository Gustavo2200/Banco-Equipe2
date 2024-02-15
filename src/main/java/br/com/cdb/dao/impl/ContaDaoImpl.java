package br.com.cdb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.cdb.dao.ContaDao;
import br.com.cdb.entity.Cliente;
import br.com.cdb.entity.Conta;

public class ContaDaoImpl implements ContaDao{
private ArrayList<Conta> listaDeContas= new ArrayList<>();
	
	@Override
	public void addConta(Conta conta) {
		listaDeContas.add(conta);
		
	}

	@Override
	public List<Conta> listar() {
		
			return listaDeContas;
		
		}

	@Override
	public Conta contaPorId(long id) {
		
		for(Conta conta:listaDeContas) {
			if(conta.getId()==id) {
			return conta;
			}
		
		}
		return null;
	}

	@Override
	public void getCpf(String cpf) {
		for(int i = 0; i<listaDeContas.size(); i++) {
			Conta contaDao = listaDeContas.get(i);
			if(listaDeContas.get(i).getCpfDoCliente() == cpf){
				
			}
		}
		
	}
}
