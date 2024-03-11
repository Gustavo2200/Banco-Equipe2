package br.com.cdb.service;

import java.util.List;

import br.com.cdb.entity.Transferencia;
import br.com.cdb.entity.dto.TransferenciaDto;

public interface TransferenciaService {
void salvar(Transferencia t);
List<TransferenciaDto> historico (int numero);
List<TransferenciaDto> transferencias();
}
