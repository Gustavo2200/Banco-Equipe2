package br.com.cdb.service;

import java.util.List;

import br.com.cdb.entity.Transferencia;

public interface TransferenciaService {
void salvar(Transferencia t);
List<Transferencia> historico (int numero);
List<Transferencia> transferencias();
}
