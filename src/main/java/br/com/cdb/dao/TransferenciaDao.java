package br.com.cdb.dao;

import java.util.List;

import br.com.cdb.entity.Transferencia;

public interface TransferenciaDao {
	void salvar(Transferencia transferencia);
	List<Transferencia> historico(int numero);
	List<Transferencia> transferencia();
}
