//package br.com.cdb.dao.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import br.com.cdb.dao.TransferenciaDao;
//import br.com.cdb.entity.Transferencia;
//import br.com.cdb.entity.dto.TransferenciaDto;
//
//public class TransferenciaDaoImpl implements TransferenciaDao{
//	private ArrayList<TransferenciaDto> transferencias = new ArrayList<TransferenciaDto>();
//	
//	@Override
//	public List<TransferenciaDto> historico(int numero) {
//		List<TransferenciaDto> t = new ArrayList<TransferenciaDto>();
//		for(TransferenciaDto transf: transferencias) {
//		if(transf.getContaOrigem() == numero|| transf.getContaDestino() == numero) {
//				t.add(transf);
//			}
//		}
//		return t;
//	}
//
//	@Override
//	public List<TransferenciaDto> transferencia() {
//		return transferencias;
//	}
//
//	@Override
//	public void salvar(TransferenciaDto transferencia) {
//		transferencia.setId(transferencias.size());
//		transferencias.add(transferencia);
//		
//	}
//
//}
