package br.com.cdb.entity;

public class Cliente {

	private String nome;
	private String dataNascimento;
	private String cpf;
	private String email;
	private String senha;
	private long id;
	
	public Cliente() {}
	
	public Cliente (String nome, String senha) {
		this.nome=nome;
		this.senha=senha;
	}
		public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		String regex = "^[0-9]{3}[0-9]{3}[0-9]{3}[0-9]{2}$";
		String cpfFormatado = cpf.replace("-", "").replace(".", "");
		cpf = cpfFormatado.strip();
		if (cpf.matches(regex)) {
			this.cpf = cpf;
		} else {
			throw new RuntimeException("Erro, cpf inv�lido!");
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		String n = nome;
		nome = n.strip();
		String regex = "^[\\p{L}çÇ]+$";
		if(nome != null && nome.matches(regex)) {
			this.nome = nome;
		}
		else
			throw new RuntimeException("Nome é obrigatório");
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		String regex = "^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}$";
		if (dataNascimento.matches(regex))
		this.dataNascimento = dataNascimento;
		else
			throw new RuntimeException("Data inválida");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		String regex= "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
				+ "";
		if(email != null && email.matches(regex)) {
			this.email = email;
		}
		else
			throw new RuntimeException("Email inválido\n"+"Ex: example@gmail.com");
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		String regex = "^.{8,}$";
		if (senha.matches(regex)) {
			this.senha = senha;
		} else {
			throw new RuntimeException("Erro, senha inv�lida!");
		}

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
