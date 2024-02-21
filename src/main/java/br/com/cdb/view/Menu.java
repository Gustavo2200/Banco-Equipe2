//package br.com.cdb.view;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//import br.com.cdb.entity.Cliente;
//import br.com.cdb.entity.Conta;
//import br.com.cdb.entity.Transferencia;
//import br.com.cdb.enums.TipoConta;
//import br.com.cdb.enums.TipoPagamento;
//import br.com.cdb.service.ClienteService;
//import br.com.cdb.service.ContaService;
//
//public class Menu {
//
//	private ClienteService clienteService;
//	private ContaService contaService;
//	private TransferenciaService transferenciaService;
//	private Scanner input = new Scanner(System.in);
//
//	public Menu(ClienteService clienteService, ContaService contaService, TransferenciaService transferenciaService) {
//		this.contaService = contaService;
//		this.contaService = contaService;
//		this.transferenciaService = transferenciaService;
//	}
//
//	public void executar() {
//		while (true) {
//			menuPrincipal();
//		}
//	}
//
//	private void menuPrincipal() {
////		Cliente c = new Cliente("Yago","12345678901","16/02/2005","yago.piovarczik1@gmail.com","13-35914787",12345678, new Conta(8735,76452534,1234));
////        Cliente c2 = new Cliente("Eduardo","12345678901","12/12/2007","eu1@gmail.com","31995306082",12345678, new Conta(1234,12312312,1234));
////        clienteService.salvarCliente(c);
////        clienteService.salvarCliente(c2);
////        contaService.salvarConta(c.getConta());
////       contaService.salvarConta(c2.getConta());
//
//		System.out.println("1-Cadastrar\n" + "2-Realizar login");
//
//		int opcao = input.nextInt();
//
//		switch (opcao) {
//
//		case 1:
//			cadastrarCliente();
//			break;
//		case 2:
//			Login();
//			break;
//		}
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
//			Cliente cliente = new Cliente(nome, senha);
//			clienteService.addCliente(cliente);
//			System.out.println("Cliente cadastrado com sucesso!");
//		} catch (Exception e) {
//			System.out.println("Erro ao cadastrar, tente novamente");
//		}
//
//	}
//
//	private void Login() {
//		int escolha = 0;
//		Cliente clienteLogado;
//		while (escolha != 3) {
//			int opcao;
//			System.out.println("Insira 1 para efetuar login e 2 para sair");
//			opcao = input.nextInt();
//
//			switch (opcao) {
//
//			case 1:
//				System.out.println("Insira seu nome:");
//				String nome = input.nextLine();
//
//				System.out.println("Insira uma senha");
//				String senha = input.nextLine();
//				try {
//					clienteLogado = clienteService.login(nome, senha);
//					System.out.println("Login realizado! ");
//					menuPrincipal();
//				} catch (RuntimeException e) {
//
//					System.out.println("Tente novamente.");
//				}
//				break;
//			case 2:
//				menuBanco();
//				break;
//			}
//		}
//	}
//
//	private void menuBanco() {
//		boolean repet = true;
//		while (repet) {
//
//			System.out.println("1. Consultar Saldo.");
//			System.out.println("2. Depositar.");
//			System.out.println("3. Transferencia via PIX.");
//			System.out.println("4. Transferencia via TED.");
//			System.out.println("5. Ver Historico de Transferência.");
//			System.out.println("6. Voltar.");
//
//			int option = 0;
//			while (true) {
//				try {
//					System.out.println("Sua escolha:");
//					option = input.nextInt();
//					input.nextLine();
//					break;
//				} catch (Exception e) {
//					System.out.println("Opção inválida.");
//					input.nextLine();
//				}
//			}
//			Conta cliente;
//			switch (option) {
//
//			case 1:
//
//				System.out.println("Seu saldo atual: ");
//				System.out.println(cliente.getSaldo());
//				break;
//
//			case 2:
//
//				System.out.println("Digite o valor a Depositar: ");
//				double valor = input.nextDouble();
//
//				if (valor > 0) {
//					double novoSaldo = cliente.getSaldo() + valor;
//					System.out.println("Depósito de R$" + valor + " realizado com sucesso. Novo saldo: R$" + novoSaldo);
//					cliente.setSaldo(novoSaldo);
//
//				} else {
//					System.out.println("Valor de depósito inválido. Tente novamente.");
//				}
//
//				break;
//
//			case 3:
//
//				System.out.println("Digite a chave pix:");
//				String chavePix = input.nextLine();
//
//				System.out.println("Digite o número da conta de origem:");
//				int numeroContaOrigem = input.nextInt();
//				input.nextLine();
//
//				Conta contaOrigem = null;
//				
//				for (Conta conta : contaDao.conta {
//					if (conta.getNumeroConta() == numeroContaOrigem) {
//						contaOrigem = conta;
//						break;
//					}
//				}
//
//				if (contaOrigem != null) {
//					Conta contaDestino = contaService.registrarPix(chavePix);
//
//					Cliente clienteDestino = null;
//					for (Cliente cliente : clienteService.getIdCliente())
//						for (Conta conta : cliente.getContas()) {
//							if (conta.getNumeroConta() == contaDestino.getNumeroConta()) {
//								clienteDestino = cliente;
//								break;
//							}
//						}
//					
//					if (clienteDestino != null) {
//						break;
//					}
//					
//					if (clienteDestino!= null) {
//					System.out.println("O titular da conta destino é " + clienteDestino.getNome() + "? É isso mesmo?");
//					String simNao = input.nextLine();
//
//					if (simNao.equalsIgnoreCase("sim")) {
//						System.out.println("Digite o valor:");
//						double valorTransferencia = input.nextDouble();
//
//						if (valorTransferencia < 0) {
//							System.out.println("Valor de transferência inválido. Insira um valor positivo.");
//						} else if (contaOrigem.getSaldo() >= valorTransferencia) {
//							System.out.println("Digite sua senha de 4 números:");
//							int senha = input.nextInt();
//							input.nextLine();
//
//							if (contaOrigem.getSenha() == senha) {
//								contaService.transferencia(contaOrigem, contaDestino, valorTransferencia,
//										TipoPagamento.PIX);
//								transferenciaService.salvarTransferencia(new Transferencia(contaOrigem, contaDestino,
//										valorTransferencia, TipoPagamento.PIX));
//								System.out.println("Transferência via PIX realizada com sucesso.");
//							} else {
//								System.out.println("Senha incorreta.");
//							}
//						} else {
//							System.out.println("Saldo insuficiente para realizar a transferência.");
//						}
//					} else {
//						System.out.println("Voltando ao menu anterior...");
//					}
//				} else {
//					System.out
//							.println("Conta de origem não encontrada. Verifique o número da conta e tente novamente.");
//				}
//				break;
//				}
//
//			case 4:
//
//				System.out.println("Digite a agência da conta:");
//				int agencia = input.nextInt();
//				input.nextLine();
//
//				System.out.println("Digite o numero da conta:");
//				int numeroConta = input.nextInt();
//				input.nextLine();
//				
//                Cliente clienteDestinoTed= null;
//				Conta contaDestinoTed = null;
//
//				
//				for (Cliente cliente : clienteService.getClientes()) {
//			            for (Conta conta : cliente.getContas()) {
//			                if (conta.getAgencia() == agencia && conta.getNumeroConta() == contaDestinoTed.getNumeroConta()) {
//			                    clienteDestinoTed = cliente;
//			                    contaDestinoTed = conta;
//			                    break;
//			                }
//			            }
//			            if (clienteDestinoTed != null) {
//			                break;
//			            }
//			        }
//
//			        if (clienteDestinoTed != null && clienteDestinoTed != null) {
//			            System.out.println("O titular da conta destino é " + clienteDestinoTed.getNome() + "? É isso mesmo?");
//			            String simNaoTed = input.nextLine();
//
//			            if (simNaoTed.equalsIgnoreCase("sim")) {
//			                System.out.println("Digite o valor:");
//			                double valorTransferenciaTed = input.nextDouble();
//
//			                if (valorTransferenciaTed < 0) {
//			                    System.out.println("Valor de transferência inválido. Insira um valor positivo.");
//			                } else if (contaOrigem.getSaldo() >= valorTransferenciaTed) {
//			                    System.out.println("Digite sua senha de 4 números:");
//			                    String senhaTed = input.nextLine();
//			                    input.nextLine();
//
//			                    if (contaOrigem.getSenha() == senhaTed) {
//			                        contaService.transferencia(contaOrigem, contaDestinoTed, valorTransferenciaTed, TipoPagamento.TED);
//			                        transferenciaService.salvarTransferencia(new Transferencia(contaOrigem, contaDestinoTed, valorTransferenciaTed, TipoPagamento.TED));
//			                        System.out.println("Transferência via TED realizada com sucesso.");
//			                    } else {
//			                        System.out.println("Senha incorreta.");
//			                    }
//			                } else {
//			                    System.out.println("Saldo insuficiente para realizar a transferência.");
//			                }
//			            } else {
//			                System.out.println("Voltando ao menu anterior...");
//			            }
//			        } else {
//			            System.out.println("Conta destino não encontrada. Verifique a agência e número da conta e tente novamente.");
//			        }
//				} else {
//			        System.out.println("Conta destino não encontrada. Verifique a agência e número da conta e tente novamente.");
//			    }
//				
//			    break;
//		
//			case 5:
//				for (Transferencia transferencia : transferenciaService.transferencias()) {
//					if (contaOrigem.getNumeroConta() == transferencia.getContaOrigem().getNumeroConta()
//							|| contaOrigem.getNumeroConta() == transferencia.getContaDestino().getNumeroConta()) {
//						if (contaOrigem.getNumeroConta() == transferencia.getContaOrigem().getNumeroConta()) {
//							System.out.println("Saída:");
//						} else {
//							System.out.println("Entrada:");
//						}
//						System.out.println(transferencia);
//					}
//				}
//				break;
//
//			case 6:
//				repet = false;
//				break;
//			}
//		}
//	}
//
//	private void registrarMenu() {
//		Cliente cliente = new Cliente();
//		String nome = "";
//		while (true) {
//			System.out.println("Digite seu nome:");
//			try {
//				nome = input.nextLine();
//				cliente.setNome(nome);
//				break;
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
//		String cpf = "";
//		while (true) {
//			System.out.println("Digite seu cpf:");
//			try {
//				cpf = input.nextLine();
//				cliente.setCpf(cpf);
//				break;
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
//		String dataDeNascimento = "";
//		while (true) {
//			System.out.println("Digite sua data de nascimento:");
//			try {
//				dataDeNascimento = input.nextLine();
//				cliente.setDataNascimento(dataDeNascimento);
//				break;
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
//		String email = "";
//		while (true) {
//			System.out.println("Digite seu email:");
//			try {
//				email = input.nextLine();
//				cliente.setEmail(email);
//				break;
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
//
//		String senha;
//		while (true) {
//			System.out.println("Digite sua senha do app (8 digitos):");
//			try {
//				senha = input.nextLine();
//				cliente.setSenha(senha);
//				break;
//			} catch (InputMismatchException e) {
//				System.out.println("Apenas numeros.");
//				input.nextLine();
//			} catch (Exception ex) {
//				System.out.println(ex.getMessage());
//			}
//		}
//
//		int agencia = contaService.numeroAgencia();
//		int numeroConta = contaService.numerConta(null);
//
//		System.out.println("\nVamos Criar sua conta:");
//		System.out.println("Sua agência é: " + agencia);
//		System.out.println("O numero da sua conta é: " + numeroConta);
//
//		String senhaConta;
//		Conta conta = new Conta();
//
//		while (true) {
//			System.out.println("Digite sua senha de Transferência (4 digitos):");
//			try {
//				senhaConta = input.nextLine();
//				conta.setSenha(senhaConta);
//				break;
//			} catch (InputMismatchException e) {
//				System.out.println("Apenas numeros.");
//				input.nextLine();
//			} catch (Exception ex) {
//				System.out.println(ex.getMessage());
//			}
//		}
//
//		System.out.println("Voce ganhou um saldo de 100 reais.");
//		System.out.println("Conta Criada");
//
//		Conta conta1 = new Conta(senha, numeroConta, agencia);
//
//		ContaService.salvarConta(conta);
//		Cliente cliente1 = new Cliente(nome, senha);
//
//		clienteService.salvarCliente(cliente1);
//		System.out.println("Cliente registrado com sucesso.");
//	}
//
//}
