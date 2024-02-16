package br.com.cdb.view;
import java.util.Scanner;

import br.com.cdb.entity.Cliente;
import br.com.cdb.service.ClienteService;

public class Menu {
	
	
	ClienteService cS;
	Scanner input=new Scanner(System.in);
	
	public Menu(ClienteService clientS) {
		this.cS= clientS;
	}
	private void login() {
		
		System.out.println("Insira 1- Se cadastrar\n"
				+ "Insira 2- Realizar login");
	
	
		int opcao=input.nextInt();
		
		switch(opcao) {
		
			case 1:
				cadastrarCliente();
				break;
			case 2:
				efetuarLogin();
				break;
		
		}
	
	
	
	}

	private void menuPrincipal() {
		System.out.println("Bem vindo ao Y Bank!"+"\n"
							+"1-Depositar\n"
							+"2-Ver saldo\n"+
							"3-Sacar\n"+
							"4-Transferir\n"+
							"5-Listar");
		
		
	}
	
	
	
	
	private void cadastrarCliente() {
		
		System.out.println("Insira seu nome:");
		String nome=input.nextLine();
		
		System.out.println("Insira uma senha");
		String senha=input.nextLine();
		
		try {
	        Cliente cliente = new Cliente(nome, senha);
	        cS.addCliente(cliente);
	        System.out.println("Cliente cadastrado com sucesso!");
	    } catch (Exception e) {
	        System.out.println("Erro ao cadastrar, tente novamente");
	    }
		
		
		
	}

	private void efetuarLogin() {
		int escolha=0;
		Cliente clienteLogado;
		while(escolha!=3) {
			int opcao;
			System.out.println("Insira 1 para efetuar login e 2 para sair");
			opcao=input.nextInt();
			
			switch(opcao) {
			
			case 1:
				System.out.println("Insira seu nome:");
				String nome=input.nextLine();
				
				System.out.println("Insira uma senha");
				String senha=input.nextLine();
				try {
		            clienteLogado = cS.login(nome, senha);
		            System.out.println("Login reealizado! ");
		            menuPrincipal();
		        } catch (RuntimeException e) {
		            
		            System.out.println("Tente novamente.");
		        }
				break;
			case 2:
				login();
			break;
			
			
			
			
			}
			
			
		}
		
	}



}
