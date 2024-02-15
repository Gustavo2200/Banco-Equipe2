package ClienteDaoImpl;

import java.util.List;

import javax.xml.crypto.Data;

import br.com.cdb.Dao.Dao;
import br.com.cdb.entity.Cliente;

public class ClienteDao implements Dao {

	private List<Cliente> listaDeClientes;

	public ClienteDao(List<Cliente> listadeclientes) {
		this.listaDeClientes = listadeclientes;
	}

	@Override
	public void addCliente(Cliente cliente) {
		cliente.setId(listaDeClientes.size());
		listaDeClientes.add(cliente);
	}

	@Override
	public Cliente getIdCliente( long id) {
		for (int i = 0; i <listaDeClientes.size(); i++) {
			Cliente clientes = listaDeClientes.get(i);
			if (listaDeClientes.get(i).getId() == id) {
				return clientes;
			}
		}
		return null;
	}

	@Override
	public Cliente login(String nome, String senha) {
	for(int i = 0; i < listaDeClientes.size(); i++) {
		Cliente clientes = listaDeClientes.get(i);
		if(listaDeClientes.get(i).getNome()== nome && listaDeClientes.get(i).getSenha() == senha){
			return clientes;
		}
	}
	return null;
		
	}
	
	
}