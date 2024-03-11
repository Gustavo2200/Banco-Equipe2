package br.com.cdb.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cdb.dao.TransferenciaDao;
import br.com.cdb.entity.Transferencia;
import br.com.cdb.entity.dto.TransferenciaDto;
import br.com.cdb.service.TransferenciaService;
@Service
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
	public List<TransferenciaDto> historico(int numero) {
		return transDao.historico(numero);
	}

	@Override
	public List<TransferenciaDto> transferencias() {
		return transDao.transferencia();
	}

}
