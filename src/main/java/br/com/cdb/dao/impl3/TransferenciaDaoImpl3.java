package br.com.cdb.dao.impl3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cdb.dao.TransferenciaDao;
import br.com.cdb.dao.repository.TransferenciaRepository;
import br.com.cdb.entity.Transferencia;
import br.com.cdb.entity.dto.TransferenciaDto;
@Repository
public class TransferenciaDaoImpl3 implements TransferenciaDao {

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	@Override
	public void salvar(Transferencia transferencia) {
		transferenciaRepository.save(transferencia);

	}

	@Override
	public List<TransferenciaDto> historico(int numero) {
		List<TransferenciaDto> historico = new ArrayList<>();
		for (Transferencia t : transferenciaRepository.findAll()) {
			if (t.getPessoa1() == numero || t.getPessoa2() == numero) {
				TransferenciaDto transfDto = new TransferenciaDto();
				transfDto.setContaDestino(t.getPessoa2());
				transfDto.setContaOrigem(t.getPessoa1());
				transfDto.setId(t.getId());
				transfDto.setTipoTransferencia(t.getTipo());
				transfDto.setValor(t.getValor());
				historico.add(transfDto);
			}
		}
		return historico;
	}

	@Override
	public List<TransferenciaDto> transferencia() {
		
		List<TransferenciaDto> transferenciaDto = new ArrayList<>();
		
		for(Transferencia t: transferenciaRepository.findAll()) {
			TransferenciaDto transfDto = new TransferenciaDto();
			transfDto.setContaOrigem(t.getPessoa1());
			transfDto.setContaDestino(t.getPessoa2());
			transfDto.setId(t.getId());
			transfDto.setTipoTransferencia(t.getTipo());
			transfDto.setValor(t.getValor());
			transferenciaDto.add(transfDto);
		}
		return transferenciaDto;
	}

}