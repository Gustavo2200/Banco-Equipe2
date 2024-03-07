package br.com.cdb.view;

import br.com.cdb.service.ClienteService;
import br.com.cdb.service.impl.ClienteServiceImpl;
import br.com.cdb.dao.impl.ClienteDaoImpl;
import br.com.cdb.dao.impl.TransferenciaDaoImpl;
import br.com.cdb.dao.impl2.ContaDaoImpl2;
import br.com.cdb.dao.impl.ContaDaoImpl;
import br.com.cdb.service.ContaService;
import br.com.cdb.service.TransferenciaService;
import br.com.cdb.service.impl.TransferenciaServiceImpl;
import br.com.cdb.service.impl.ContaServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		ClienteService clienteService = new ClienteServiceImpl(new ClienteDaoImpl());
		ContaService contaService = new ContaServiceImpl(new ContaDaoImpl2());
		TransferenciaService transferenciaService = new TransferenciaServiceImpl(new TransferenciaDaoImpl());
		
		Menu menu = new Menu(clienteService, contaService, transferenciaService);
		menu.executar();
		
	
		
	}
}
