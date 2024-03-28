package br.com.cdb.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.cdb.dao.ClienteDao;
import br.com.cdb.entity.Cliente;
import br.com.cdb.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Qualifier("ClienteDaoJdbc")
	@Autowired
	private ClienteDao clienteDao;

	@Override
	public void addCliente(Cliente cliente) {
		clienteDao.addCliente(cliente);
	}

	@Override
	public Cliente login(String nome, String senha) {
		Cliente cliente = clienteDao.login(nome, senha);
		if (cliente != null) {
			if (senha.equals(cliente.getSenha())) {
				return cliente;
			} else {
				throw new RuntimeException("Senha inválida");
			}
		} else {
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
		cpf = cpfFormatado.strip();
		if (cpf.matches(regex)) {
			Cliente cliente = CpfExiste(cpf);
			if (cliente != null) {
				throw new RuntimeException("Cpf ja cadastrado");
			}

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
		if (nome != null && nome.matches(regex)) {
			return nome;
		} else
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
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$" + "";
		if (email != null && email.matches(regex)) {
			return email;
		} else
			throw new RuntimeException("Email inválido\n" + "Ex: example@gmail.com");
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

	@Override
	public Cliente CpfExiste(String cpf) {
		return clienteDao.CpfExiste(cpf);
	}

	@Override
	public String validacaoDataNascimento(String dataNascimento) {
		try {
			SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
			formatoData.setLenient(false);

			Date d = formatoData.parse(dataNascimento);
			int anoNascimento = Integer.parseInt(dataNascimento.substring(0, 4));
			if (anoNascimento >= 1940) {
				return dataNascimento;
			} else {
				throw new IllegalArgumentException("Ano de nascimento deve ser maior ou igual a 1940.");
			}
		} catch (ParseException e) {
			throw new IllegalArgumentException("Formato de data inválido. Utilize o padrão yyyy-MM-dd");
		}
	}

}
