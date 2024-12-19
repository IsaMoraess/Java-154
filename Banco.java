package EXERCICIO_1;

import java.util.ArrayList;
import java.util.List;

class ContaBancaria {
    private String numeroConta;
    private double saldo;

    public ContaBancaria(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void transferir(ContaBancaria destino, double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            destino.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente para a transferência!");
        }
    }
}

class Banco {
    private List<ContaBancaria> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void criarConta(String numeroConta, double saldoInicial) {
        ContaBancaria conta = new ContaBancaria(numeroConta, saldoInicial);
        contas.add(conta);
    }

    public void realizarTransferencia(String numeroContaOrigem, String numeroContaDestino, double valor) {
        ContaBancaria origem = null, destino = null;
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroContaOrigem)) {
                origem = conta;
            }
            if (conta.getNumeroConta().equals(numeroContaDestino)) {
                destino = conta;
            }
        }

        if (origem != null && destino != null) {
            origem.transferir(destino, valor);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public double calcularSaldoTotal() {
        double total = 0;
        for (ContaBancaria conta : contas) {
            total += conta.getSaldo();
        }
        return total;
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.criarConta("123", 1000);
        banco.criarConta("456", 500);
        banco.realizarTransferencia("123", "456", 200);
        System.out.println("Saldo total do banco: " + banco.calcularSaldoTotal());
    }
}

