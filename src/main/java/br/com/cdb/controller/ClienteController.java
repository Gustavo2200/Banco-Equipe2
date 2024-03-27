package br.com.cdb.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.cdb.entity.Cliente;
import br.com.cdb.service.impl.ClienteServiceImpl;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteServiceImpl cServ;
	@PostMapping("/cadastro")
	public ResponseEntity<String> addCliente(@RequestBody Cliente cliente) {
	    try {
	        cServ.validacaoNome(cliente.getNome());
	        cServ.validacaoCpf(cliente.getCpf());
	        cServ.validacaoSenha(cliente.getSenha());
	        cServ.validacaoEmail(cliente.getEmail());

	        cServ.addCliente(cliente);
	        
	        return new ResponseEntity<>("Cadastro realizado com sucesso", HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>("Não foi possível realizar o cadastro, email já registrado", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}


	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody HashMap<String,String> login){
			
			String nome=login.get("nome");
			String senha=login.get("senha");
			cServ.validacaoNome(nome);
            cServ.validacaoSenha(senha);
			
			cServ.login(nome, senha);
		
		return new ResponseEntity("Login realizado",HttpStatus.OK);
		
		}



}
