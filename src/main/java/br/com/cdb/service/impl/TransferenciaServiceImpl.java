package br.com.cdb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.cdb.dao.TransferenciaDao;
import br.com.cdb.entity.Transferencia;
import br.com.cdb.entity.dto.TransferenciaDto;
import br.com.cdb.service.TransferenciaService;
@Service
public class TransferenciaServiceImpl implements TransferenciaService {
	@Qualifier("TransferenciaDaoJDBC")
	@Autowired
	private TransferenciaDao transDao;
	
	
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
