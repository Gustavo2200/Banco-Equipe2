package br.com.cdb.service.impl;


import br.com.cdb.dao.ClienteDao;
import br.com.cdb.entity.Cliente;
import br.com.cdb.service.ClienteService;


public class ClienteServiceImpl implements ClienteService {
	private ClienteDao clienteDao;
	public ClienteServiceImpl(ClienteDao cd) {
		this.clienteDao = cd;
	}
	
	@Override
	public void addCliente(Cliente cliente) {
		Cliente c = clienteDao.CpfExiste(cliente.getCpf());
		if(c==null) {
		clienteDao.addCliente(cliente);
		}
		else {
			throw new RuntimeException("Cpf já cadastrado");
		}
	}


	@Override
	public Cliente login(String nome, String senha) {
		Cliente cliente = clienteDao.login(nome, senha);
		if(cliente != null) {
			if(senha.equals(cliente.getSenha())){
				return cliente;
			}
			else {
				throw new RuntimeException("Senha inválida");
			}
		}
		else {
			throw new RuntimeException("Usuário inválida");
		}
	}

	@Override
	public Cliente getIdCliente(long id) {
		return clienteDao.getIdCliente(id);
	}
	@Override
	public String validacaoCpf(String cpf) {
		String regex = "^[0-9]{3}[0-9]{3}[0-9]{3}[0-9]{2}$";
		String cpfFormatado = cpf.replace("-", "").replace(".", "");
		cpf=cpfFormatado.strip();
		if (cpf.matches(regex)) {
			return cpf;
				
		} else {
			throw new RuntimeException("Erro, cpf inv�lido!");
		}
	}
	@Override
	public String validacaoNome(String nome) {
		String n = nome;
		nome = n.strip();
		String regex = "^[\\p{L}çÇ]+$";
		if(nome != null && nome.matches(regex)) {
			return nome;
		}
		else
			throw new RuntimeException("Nome é obrigatório");
	}
	@Override
	public String validacaoData(String dataNascimento) {
		String regex = "^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}$";
		if (dataNascimento.matches(regex))
		 return dataNascimento;
		else
			throw new RuntimeException("Data inválida");
	}
	@Override
	public String validacaoEmail(String email) {
		String regex= "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
				+ "";
		if(email != null && email.matches(regex)) {
			return email;
		}
		else
			throw new RuntimeException("Email inválido\n"+"Ex: example@gmail.com");
	}
	@Override
	public String validacaoSenha(String senha) {
		String regex = "^.{8,}$";
		if (senha.matches(regex)) {
			return senha;
		} else {
			throw new RuntimeException("Erro, senha inv�lida!");
		}
	}

}
