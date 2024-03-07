package br.com.cdb.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Cliente {

	private String nome;
	private String dataNascimento;
	private String cpf;
	private String email;
	private String senha;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private long id;
	
	public Cliente() {}
	
	public Cliente (String nome, String senha, String dataNascimento, String cpf, String email) {
		this.nome=nome;
		this.senha=senha;
		this.cpf=cpf;
		this.dataNascimento=dataNascimento;
		this.email=email;
	}
		public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf=cpf;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
	this.nome=nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento=dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email=email;
	}
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha=senha;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
