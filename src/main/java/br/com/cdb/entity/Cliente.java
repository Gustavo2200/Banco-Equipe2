package br.com.cdb.entity;

public class Cliente {

	private String nome;
	private String dataNascimento;
	private String cpf;
	private String email;
	private String senha;
	private long id;

	public Cliente() {
	}

	public String getCpf() {
		return cpf;
	}

	public void setcpf(String cpf) {
		String regex = "^[0-9]{3}[0-9]{3}[0-9]{3}[0-9]{2}$";
		if (cpf.matches(regex)) {
			this.cpf = cpf;
		} else {
			throw new RuntimeException("Erro, cpf inválido!");
		}

	}

	public String getNome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		String regex = "^.{8,}$";
		if (senha.matches(regex)) {
			this.senha = senha;
		} else {
			throw new RuntimeException("Erro, senha inválida!");
		}

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
