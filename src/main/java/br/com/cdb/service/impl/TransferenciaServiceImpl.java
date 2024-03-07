package br.com.cdb.service.impl;

import java.util.List;

import br.com.cdb.dao.TransferenciaDao;
import br.com.cdb.entity.Transferencia;
import br.com.cdb.service.TransferenciaService;

public class TransferenciaServiceImpl implements TransferenciaService {
	private TransferenciaDao transDao;
	
	public TransferenciaServiceImpl(TransferenciaDao dao) {
		this.transDao = dao;
	}
	@Override
	public void salvar(Transferencia t) {
	 transDao.salvar(t);
	}

	@Override
	public List<Transferencia> historico(int numero) {
		return transDao.historico(numero);
	}

	@Override
	public List<Transferencia> transferencias() {
		return transDao.transferencia();
	}

}
