package br.com.cdb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.cdb.dao.ContaDao;
import br.com.cdb.entity.Conta;

public class ContaDaoImpl implements ContaDao{
private ArrayList listaDeContas= new ArrayList<>();
	
	@Override
	public void addConta(Conta conta) {
		listaDeContas.add(conta);
		
	}

	@Override
	public List<Conta> listar() {
		List <Conta> contas= new ArrayList<>();
		
		for(Conta conta:listaDeContas) {
			System.out.println(conta);
		}
		return contas;
	}

	@Override
	public void contaPorId(long id) {
		
		for(Conta conta:listaDeContas) {
			if(conta.get)
		}
		
	}
}
