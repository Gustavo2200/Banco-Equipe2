package br.com.cdb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.cdb.dao.TransferenciaDao;
import br.com.cdb.entity.Transferencia;

public class TransferenciaDaoImpl implements TransferenciaDao{
	private ArrayList<Transferencia> transferencias = new ArrayList<Transferencia>();
	
	@Override
	public List<Transferencia> historico(int numero) {
		List<Transferencia> t = new ArrayList<Transferencia>();
		for(Transferencia transf: transferencias) {
			if(transf.getPessoa1() == numero) {
				t.add(transf);
			}
		}
		return t;
	}

	@Override
	public List<Transferencia> transferencia() {
		return transferencias;
	}

	@Override
	public void salvar(Transferencia transferencia) {
		transferencia.setId(transferencias.size());
		transferencias.add(transferencia);
		
	}

}
