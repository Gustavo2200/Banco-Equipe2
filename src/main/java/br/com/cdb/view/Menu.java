package br.com.cdb.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import br.com.cdb.entity.Cliente;
import br.com.cdb.entity.Conta;
import br.com.cdb.entity.Transferencia;
import br.com.cdb.enums.TipoPagamento;
import br.com.cdb.service.ClienteService;
import br.com.cdb.service.ContaService;
import br.com.cdb.service.TransferenciaService;

public class Menu {

	private ClienteService clienteService;
	private ContaService contaService;
	private TransferenciaService transferenciaService;
	private Scanner input = new Scanner(System.in);

	public Menu(ClienteService clienteService, ContaService contaService, TransferenciaService transferenciaService) {
		this.clienteService = clienteService;
		this.contaService = contaService;
		this.transferenciaService = transferenciaService;
	}

	public void executar() {
		Cliente c = new Cliente("Yago","12345678","16/02/2005","12345678910","yago.piovarczik1@gmail.com");
        Cliente c2 = new Cliente("Eduardo","12345679","12/12/2007", "23456789101", "Eduardo@gmail.com");
        clienteService.addCliente(c);
        clienteService.addCliente(c2);
        contaService.addConta(new Conta("1234", 0, 12345678, 1234, "12345678910" ));
        contaService.addConta(new Conta("1000", 0, 10000000, 1000, "23456789101" ));
		while (true) {
			menuPrincipal();
		}
	}

	private void menuPrincipal() {
		System.out.println("1-Cadastrar\n" + "2-Realizar login");

		int opcao = input.nextInt();
        input.nextLine();
		switch (opcao) {

		case 1:
			cadastrarCliente();
			break;
		case 2:
			login();
			break;
		}
	}


	private void login() {
		int escolha = 0;
		Cliente clienteLogado = null;
		
				System.out.println("Insira seu nome:");
				String nome = input.nextLine();

				System.out.println("Insira uma senha");
				String senha = input.nextLine();
				try {
					clienteLogado = clienteService.login(nome, senha);
					System.out.println("Login realizado! ");
					
				} catch (RuntimeException e) {

					System.out.println("Tente novamente.");
				}
				
				 menuBanco(clienteLogado);
	}

	private void menuBanco(Cliente clienteLogado) {
        boolean repet = true;
        while (repet) {

            System.out.println("1. Consultar Saldo.");
            System.out.println("2. Depositar.");
            System.out.println("3. Transferencia via PIX.");
            System.out.println("4. Transferencia via TED.");
            System.out.println("5. Ver Historico de Transferência.");
            System.out.println("6. Voltar.");

            int option = 0;
            while (true) {
                try {
                    System.out.println("Sua escolha:");
                    option = input.nextInt();
                    input.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Opção inválida.");
                    input.nextLine();
                }
            }
            
            Conta conta = contaService.getCpf(clienteLogado.getCpf());
           
            switch (option) {
          
                case 1:
                
                    System.out.println("Seu saldo atual: ");
                    System.out.println(conta.getSaldo());
                    break;

                case 2:
                    System.out.println("Digite o valor a Depositar: ");
                    double valor = input.nextDouble();
                    contaService.depositar(valor, conta.getNumeroConta());
                    break;

                case 3:
                	
                    System.out.println("Digite a chave pix:");
                    String chavePix = input.nextLine();

                    System.out.println("Digite o valor da transferência:");
                    double valor1 = input.nextDouble();

                    contaService.transferenciaPix(conta.getId(), chavePix, valor1, TipoPagamento.PIX);
                    Transferencia transferencia2 = new Transferencia(conta.getNumeroConta(), contaService.getCpf(chavePix).getNumeroConta() , valor1, TipoPagamento.PIX);
                    transferenciaService.salvar(transferencia2);
                    break;

                case 4:
                    System.out.println("Digite a agência da conta destino:");
                    int agencia = input.nextInt();
                    input.nextLine();

                    System.out.println("Digite o número da conta origem:");
                    int numeroConta = input.nextInt();
                    input.nextLine();

                    System.out.println("Digite o valor da transferência:");
                    int valorTed = input.nextInt();
                    input.nextLine();
                    
                    contaService.transferenciaTed(agencia, numeroConta, valorTed, TipoPagamento.TED, conta.getId());
                    Transferencia transferencia1 = new Transferencia(conta.getNumeroConta(), numeroConta , valorTed, TipoPagamento.TED);
                    transferenciaService.salvar(transferencia1);
                    break;

                case 5:
                  System.out.println("Histórico de tranferência");
                    for (Transferencia transferencia : transferenciaService.historico(conta.getNumeroConta())) {
                 	   System.out.println(transferencia);
                    }
                   
                    break;

                case 6:
                    repet = false;
                    break;
                    
                case 7:
                	for(Conta cont :contaService.listar()) {
                		System.out.println(cont.getNumeroConta() + "\n");
                	}
                	break;
            }
            
        }
    }


	private void cadastrarCliente() {
		Cliente cliente = new Cliente();
		String nome = "";
		while (true) {
			System.out.println("Digite seu nome:");
			try {
				nome = input.nextLine();
				cliente.setNome(nome);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		String cpf = "";
		while (true) {
			System.out.println("Digite seu cpf:");
			try {
				cpf = input.nextLine();
				cliente.setCpf(cpf);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		String dataDeNascimento = "";
		while (true) {
			System.out.println("Digite sua data de nascimento:");
			try {
				dataDeNascimento = input.nextLine();
				cliente.setDataNascimento(dataDeNascimento);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		String email = "";
		while (true) {
			System.out.println("Digite seu email:");
			try {
				email = input.nextLine();
				cliente.setEmail(email);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		String senha;
		while (true) {
			System.out.println("Digite sua senha do app (8 digitos):");
			try {
				senha = input.nextLine();
				cliente.setSenha(senha);
				break;
			} catch (InputMismatchException e) {
				System.out.println("Apenas numeros.");
				input.nextLine();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			
		}

		int agencia = contaService.numeroAgencia();
		int numeroConta = contaService.numerConta();

		System.out.println("\nVamos Criar sua conta:");
		System.out.println("Sua agência é: " + agencia);
		System.out.println("O numero da sua conta é: " + numeroConta);

		String senhaConta;
		
		Conta conta1 = new Conta();
		while (true) {
			System.out.println("Digite sua senha de Transferência (4 digitos):");
			try {
				senhaConta = input.nextLine();
				conta1.setSenha(senhaConta);
				break;
			} catch (InputMismatchException e) {
				System.out.println("Apenas numeros.");
				input.nextLine();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

		System.out.println("Conta Criada");
		
		conta1 = new Conta(senha, 0, numeroConta, 
				agencia, cpf);
			
		contaService.addConta(conta1);
		
		Cliente cliente1 = new Cliente(nome, senha, dataDeNascimento, cpf, email);

		clienteService.addCliente(cliente1);
		System.out.println("Cliente registrado com sucesso.");
		
		menuPrincipal();
	}
}
