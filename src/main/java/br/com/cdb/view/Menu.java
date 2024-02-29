package br.com.cdb.view;

import java.util.InputMismatchException;
import java.util.List;
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
		try {System.out.println("1-Cadastrar\n" + "2-Realizar login");

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
		}catch(Exception e ) {
			System.out.println("Opcao invalida, insira 1 ou 2");
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
					menuPrincipal();
				}
				if(clienteLogado!=null) {
				 menuBanco(clienteLogado);
				}
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
            try {
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
                	System.out.println("Digite sua senha de transferência:");
					input = new Scanner(System.in);
					String senha = input.nextLine();
					if (senha.equals(conta.getSenha())) {
						System.out.println("Digite a chave pix:");
						String chavePix = input.nextLine();
 
						Conta contaDestino=contaService.getCpf(chavePix);
						if(contaDestino!=null) {
							double valor1;
							while(true) {
								try {
						System.out.println("Digite o valor da transferência:");
						 valor1 = input.nextDouble();
						 input.nextLine();
						 break;
								}catch(Exception e) {
									System.out.println("Insira uma entrada valida");
									input.nextLine();
								}
								}
						contaService.transferenciaPix(conta.getId(), chavePix, valor1, TipoPagamento.PIX);
						Transferencia transferencia2 = new Transferencia(conta.getNumeroConta(),
								contaService.getCpf(chavePix).getNumeroConta(), valor1, TipoPagamento.PIX);
						transferenciaService.salvar(transferencia2);
						}
						else {
							System.out.println("Conta não encontrada!");
						}
					}
					else {
						System.out.println("Senha incorreta");
					}
					break;
                
                	case 4:
                	
                	System.out.println("Digite a senha de transferência");
					input = new Scanner(System.in);
					String senha1 = input.nextLine();
 
					if (senha1.equals(conta.getSenha())) {
						int agencia=0;
						while(true) {
						try {
						System.out.println("Digite a agência da conta destino:");
						 agencia = input.nextInt();
						input.nextLine();
						break;
						}catch(Exception e) {
							System.out.println("Insira uma entrada valida");
							input.nextLine();
						}}
						if(contaService.getAgencia(agencia)) {
						int numeroConta=0;
						while(true) {
						try {
						System.out.println("Digite o número da conta origem:");
						 numeroConta = input.nextInt();
						input.nextLine();
						break;}catch(Exception e) {
							System.out.println("Insira uma entrada valida");
							input.nextLine();
						}}
						if(contaService.getNumero(numeroConta)) {
							double valorTed=0;
							while(true) {
								try {
						System.out.println("Digite o valor da transferência:");
						 valorTed = input.nextInt();
						input.nextLine();
						break;}catch(Exception e) {
							System.out.println("Insira uma entrada valida");
							input.nextLine();
						}
							}
						contaService.transferenciaTed(agencia, numeroConta, valorTed, TipoPagamento.TED, conta.getId());
						Transferencia transferencia1 = new Transferencia(conta.getNumeroConta(), numeroConta, valorTed,
								TipoPagamento.TED);
						transferenciaService.salvar(transferencia1);
						}
						else {
							System.out.println("Número da conta incorreto");
						}
					}
						else {
							System.out.println("Agência incorreta");
						}
					}
					else {
						System.out.println("Senha incorreta!");
					}
					break;
				
                case 5:
                	List<Transferencia> historico= transferenciaService.historico(conta.getNumeroConta());
                	if(historico.isEmpty()) {
                		System.out.println("Voce nao realizou nenhuma transferencia");
                	}
                	else {
                	System.out.println("Histórico de tranferência");
                    for (Transferencia transferencia : historico) {
                    	if(transferencia.getPessoa1() == conta.getNumeroConta()) {
                    		System.out.println("Saida:");
                    	}
                    	else {
                    		System.out.println("Entrada:");
                    	}
                    	System.out.println(transferencia);
                    }
                    
                	}
                    break;
               case 6:
                    repet = false;
                    break;
                    
            }
        }
        catch(Exception e) {
        	System.out.println(e.getMessage()); 
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
				clienteService.validacaoNome(nome);
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
				clienteService.validacaoCpf(cpf);
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
				clienteService.validacaoData(dataDeNascimento);
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
				clienteService.validacaoEmail(email);
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
				clienteService.validacaoSenha(senha);
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
				contaService.validacaoSenha(senhaConta);
				conta1.setSenha(senhaConta);
				System.out.println("Conta Criada");
				break;
			} catch (InputMismatchException e) {
				System.out.println("Apenas numeros.");
				input.nextLine();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		try {
		
		conta1 = new Conta(senha, 0, numeroConta,
				agencia, cpf);
			
		contaService.addConta(conta1);
		
		Cliente cliente1 = new Cliente(nome, senha, dataDeNascimento, cpf, email);
 
		clienteService.addCliente(cliente1);
		System.out.println("Cliente registrado com sucesso.");
		
		menuPrincipal();
		}
		catch(RuntimeException e) {
			System.out.println(e.getMessage());
			menuPrincipal();
		}
	}
}
