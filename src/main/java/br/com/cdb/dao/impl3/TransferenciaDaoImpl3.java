package br.com.cdb.dao.impl3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cdb.dao.TransferenciaDao;
import br.com.cdb.dao.repository.TransferenciaRepository;
import br.com.cdb.entity.Transferencia;

public class TransferenciaDaoImpl3 implements TransferenciaDao {

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	@Override
	public void salvar(Transferencia transferencia) {
		transferenciaRepository.save(transferencia);

	}

	@Override
	public List<Transferencia> historico(int numero) {
		List<Transferencia> historico = new ArrayList<>();
		for (Transferencia t : transferenciaRepository.findAll()) {
			if (t.getPessoa1() == numero || t.getPessoa2() == numero) {
				historico.add(t);
			}
		}
		return historico;
	}

	@Override
	public List<Transferencia> transferencia() {

		return transferenciaRepository.findAll();
	}

}