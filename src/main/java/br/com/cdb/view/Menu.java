//package br.com.cdb.view;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//import br.com.cdb.entity.Cliente;
//import br.com.cdb.entity.Conta;
//import br.com.cdb.entity.Transferencia;
//import br.com.cdb.enums.TipoPagamento;
//import br.com.cdb.service.ClienteService;
//import br.com.cdb.service.ContaService;
//
//public class Menu {
//
//    private ClienteService clienteService;
//    private ContaService contaService;
//    private Transferencia transferenciaService;
//    private Scanner input = new Scanner(System.in);
//    
//    public Menu(ClienteService clienteService, ContaService contaService, Transferencia transferenciaService){
//        this.contaService = contaService;
//        this.contaService = contaService;
//        this.transferenciaService = transferenciaService;
//    }
//
//    public void executar(){
//        while (true){
//            menuPrincipal();
//        }
//    }
//
//	
//	public Menu(ClienteService cliente) {
//		this.clienteService = cliente;
//	}
//	private void menuPrincipal() {
//		
//		System.out.println("1-Cadastrar\n"
//				+ "2-Realizar login");
//	
//	
//		int opcao = input.nextInt();
//		
//		switch(opcao) {
//		
//			case 1:
//				cadastrarCliente();
//				break;
//			case 2:
//				efetuarLogin();
//				break;
//		}
//	}
//
//	private void login() {
//		System.out.println("Bem vindo ao Y Bank!"+"\n"
//							+"1-Depositar\n"
//							+"2-Ver saldo\n"+
//							"3-Sacar\n"+
//							"4-Transferir\n"+
//							"5-Listar");
//	}
//	
//	private void cadastrarCliente() {
//		
//		System.out.println("Insira seu nome:");
//		String nome = input.nextLine();
//		
//		System.out.println("Insira uma senha");
//		String senha = input.nextLine();
//		
//		try {
//	        Cliente cliente = new Cliente(nome, senha);
//	        clienteService.addCliente(cliente);
//	        System.out.println("Cliente cadastrado com sucesso!");
//	    } catch (Exception e) {
//	        System.out.println("Erro ao cadastrar, tente novamente");
//	    }
//		
//	}
//
//	private void efetuarLogin() {
//		int escolha = 0;
//		Cliente clienteLogado;
//		while(escolha!=3) {
//			int opcao;
//			System.out.println("Insira 1 para efetuar login e 2 para sair");
//			opcao = input.nextInt();
//			
//			switch(opcao) {
//			
//			case 1:
//				System.out.println("Insira seu nome:");
//				String nome=input.nextLine();
//				
//				System.out.println("Insira uma senha");
//				String senha=input.nextLine();
//				try {
//		            clienteLogado = clienteService.login(nome, senha);
//		            System.out.println("Login realizado! ");
//		            menuPrincipal();
//		        } catch (RuntimeException e) {
//		            
//		            System.out.println("Tente novamente.");
//		        }
//				break;
//			case 2:
//				login();
//			break;
//			}
//		}
//	}
//			
//			private void menuBanco() {
//		        boolean repet = true;
//		        while (repet) {
//		   
//		            System.out.println("1. Consultar Saldo.");
//		            System.out.println("2. Depositar.");
//		            System.out.println("3. Transferencia via PIX.");
//		            System.out.println("4. Transferencia via TED.");
//		            System.out.println("5. Ver Historico de Transferência.");
//		            System.out.println("6. Voltar.");
//
//		            int option = 0;
//		            while (true) {
//		                try {
//		                    System.out.println("Sua escolha:");
//		                    option = input.nextInt();
//		                    input.nextLine();
//		                    break;
//		                } catch (Exception e) {
//		                    System.out.println("Opção inválida.");
//		                    input.nextLine();
//		                }
//		            }
//		            switch (option) {
//		               
//		                case 1:
//
//		                    System.out.println("saldo atual: ");
//		                    System.out.println(cliente.getConta().getSaldo());
//		                    break;
//		                    
//		                case 2:
//
//		                    System.out.println("Digite o valor a Depositar: ");
//		                    double valor = input.nextDouble();
//
//		                    double newBalance = cliente.getConta().getSaldo() + valor;
//
//		                    cliente.getConta().setSaldo(novoSaldo);
//		                    break;
//		                    
//		                case 3:
//
//		                    System.out.println("Digite a chave pix:");
//		                    String chavePix = input.nextLine();
//		                    Conta accountDestiny = contaService.contaPorChavePix(chavePix);
//
//		                    Cliente customerDestiny = clienteService.customerByAccount(ContaDestino);
//
//		                    System.out.println("O titular da conta destino é " + ClienteDestino.getNome() + "? É isso mesmo?");
//
//		                    String yesNo = input.nextLine();
//		                    
//		                    if (yesNo.equals("sim")) {
//		                        System.out.println("Digite o valor:");
//		                        double valorTransferencia = input.nextDouble();
//
//		                        System.out.println("Digite sua senha de 4 numeros:");
//		                        int senha = input.nextInt();
//		                        input.nextLine();
//
//		                        if (cliente.getConta().getSenha() == senha) {
//		                            ContaService.transferencia(cliente.getNumeroConta(), valorTransferencia, TipoPagamento.PIX);
//		                            transferenciaService.savarTransferencia(new Transferencia(contaDestino, cliente.getConta(), valorTransferencia, TipoPagamento.PIX));
//		                        } else {
//		                            System.out.println("Senha incorreta.");
//		                        }
//		                    } else {
//		                        System.out.println("Voltando ao menu anterior...");
//		                    }
//
//		                    break;
//		                    
//		                case 4:
//
//		                    System.out.println("Digite a agência da conta:");
//		                    int agencia = input.nextInt();
//		                    input.nextLine();
//
//		                    System.out.println("Digite o numero da conta:");
//		                    int numeroConta = input.nextInt();
//		                    input.nextLine();
//
//		                    Conta accountDestinyTed = contaService.
//		                            contaPorNumeroAgencia(agencia, numeroConta);
//
//		                    Cliente clienterDestinyTed = clienteService.customerByAccount(accountDestinyTed);
//
//		                    System.out.println("O titular da conta destino é " + clienteDestinyTed.getNome() + "? É isso mesmo?");
//		                    String yesNoTed = input.nextLine();
//		                    if (yesNoTed.equals("sim")) {
//		                        System.out.println("Digite o valor:");
//		                        double valorTransferencia = input.nextDouble();
//
//		                        System.out.println("Digite sua senha de 4 numeros:");
//		                        int senha = input.nextInt();
//		                        input.nextLine();
//
//		                        if (cliente.getConta().getsenha() == senha) {
//		                            ContaService.transferencia(cliente.getConta(), accountDestinyTed, valueTransferencia, TipoPagamento.TED);
//		                            transferenciaService.savarTransferencia(new Transferencia(accountDestinyTed, cliente.getConta(), valorTransferencia, TipoTransferencia.TED));
//		                        } else {
//		                            System.out.println("Senha incorreta.");
//		                        }
//		                    } else {
//		                        System.out.println("Voltando ao menu anterior...");
//		                    }
//		                    break;
//		                case 5:
//		                    for(Transferencia transferencia: transferenciaService.transferencia()){
//		                            if(cliente.getConta().getNumeroConta() == transferencia.getContaOrigem().getNumeroConta()){
//		                                System.out.println("Saida:");
//		                            }
//		                            else {
//		                                System.out.println("Entrada:");
//		                            }
//		                        System.out.println(transferencia);
//		                    }
//		                    break;
//		                case 6:
//		                    repet = false;
//		                    break;
//		            }
//		        }
//		    }
//			
//			 private void registrarMenu() {
//                    Cliente cliente = new Cliente();
//			        String nome = "";
//			        while (true) {
//			            System.out.println("Digite seu nome:");
//			            try{
//			                nome = input.nextLine();
//			                cliente.setNome(nome);
//			                break;
//			            }catch (Exception e){
//			                System.out.println(e.getMessage());
//			            }
//			        }
//			        String cpf = "";
//			        while (true) {
//			            System.out.println("Digite seu cpf:");
//			            try {
//			                cpf =input.nextLine();
//			                cliente.setCpf(cpf);
//			                break;
//			            }catch (Exception e){
//			                System.out.println(e.getMessage());
//			            }
//			        }
//			        String dataDeNascimento = "";
//			        while (true) {
//			            System.out.println("Digite sua data de nascimento:");
//			            try {
//			            	dataDeNascimento = input.nextLine();
//			                cliente.setDataNascimento(dataDeNascimento);
//			                break;
//			            } catch (Exception e) {
//			                System.out.println(e.getMessage());
//			            }
//			        }
//			        String email = "";
//			        while (true) {
//			            System.out.println("Digite seu email:");
//			            try {
//			                email = input.nextLine();
//			                cliente.setEmail(email);
//			                break;
//			            }catch (Exception e){
//			                System.out.println(e.getMessage());
//			            }
//			        }
//			      
//			        String senha;
//			        while (true) {
//			            System.out.println("Digite sua senha do app (8 digitos):");
//			            try {
//			               senha = input.nextLine();
//			                cliente.setSenha(senha);
//			                break;
//			            }catch (InputMismatchException e){
//			                System.out.println("Apenas numeros.");
//			                input.nextLine();
//			            }catch (Exception ex){
//			                System.out.println(ex.getMessage());
//			            }
//			        }
//			        
//			        int agencia = contaService.numeroAgencia();
//			        int numeroConta = contaService.numerConta();
//
//			        System.out.println("\nVamos Criar sua conta:");
//			        System.out.println("Sua agência é: " + agencia);
//			        System.out.println("O numero da sua conta é: " + numeroConta);
//
//			       String senhaConta;
//			        Conta conta = new Conta();
//			       
//			        while (true) {
//			            System.out.println("Digite sua senha de Transferência (4 digitos):");
//			            try {
//			                senhaConta = input.nextLine();
//			                conta.setSenha(senhaConta);
//			                break;
//			            }catch (InputMismatchException e){
//			                System.out.println("Apenas numeros.");
//			                input.nextLine();
//			            }catch (Exception ex){
//			                System.out.println(ex.getMessage());
//			            }
//			        }
//			        
//			        
//			        System.out.println("Voce ganhou um saldo de 100 reais.");
//			        System.out.println("Conta Criada");
//
//			        Conta conta1 = new Conta(agencia, NumeroConta, senha);
//
//			        ContaService.salvarConta(conta);
//			        Cliente cliente = new Cliente(nome, cpf, dataDeNascimento, email, senha);
//
//			        clienteService.addCliente(cliente);
//			        System.out.println("Cliente registrado com sucesso.");
//		}
//	
//	}
//



