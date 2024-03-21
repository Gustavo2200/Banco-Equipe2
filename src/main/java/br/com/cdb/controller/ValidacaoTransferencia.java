package br.com.cdb.controller;

public class ValidacaoTransferencia {
    public static void validarTransferencia(int idContaOrigem, String cpfDestino, double valor) {
        if (valor <= 0) {
            throw new RuntimeException("O valor da transferência deve ser maior que zero.");
        }

        double limiteMaximo = 500000;
        if (valor > limiteMaximo) {
            throw new RuntimeException("O valor da transferência não pode exceder R$" + limiteMaximo);
        }

        double saldoContaOrigem = obterSaldoConta(idContaOrigem);
        if (valor > saldoContaOrigem) {
            throw new RuntimeException("Saldo insuficiente na conta de origem.");
        }

        if (!contaDestinoExiste(cpfDestino)) {
            throw new RuntimeException("A conta de destino não é válida.");
        }
        
        }
    }
        

    }
