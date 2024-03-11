package br.com.cdb.dao;

import java.util.List;

import br.com.cdb.entity.Transferencia;
import br.com.cdb.entity.dto.TransferenciaDto;

public interface TransferenciaDao {
	void salvar(Transferencia transferencia);
	List<TransferenciaDto> historico(int numero);
	List<TransferenciaDto> transferencia();
}
