package br.com.cdb.entity;
public class Cliente {

	private String nome;
	private  String dataNascimento;
	private String cpf;
	private String email;
	private String senha;
	private long id;
	
	public Cliente (String nome, String senha) {
		this.nome=nome;
		this.senha=senha;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setcpf(String cpf) {
		this.cpf = cpf;
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
		this.senha = senha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
