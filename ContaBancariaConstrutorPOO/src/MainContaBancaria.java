/*
Descrição

Você está desenvolvendo um programa simples em Java para representar uma conta bancária.
Utilizando programação orientada a objetos (POO), você criará uma classe ContaBancaria com um construtor que
permitirá a inicialização da conta com um saldo inicial.


Entrada

O programa solicitará ao usuário que informe o saldo inicial da conta.
Em seguida, o programa solicitará ao usuário que realize transações de depósito e saque.


Saída

A classe ContaBancaria conterá métodos para realizar depósitos e saques, atualizando o saldo da conta.
O saldo atual será exibido após cada transação.
Se o valor do saque for maior que o saldo disponível na conta, imprima uma mensagem informando:
Saldo insuficiente. Saque não realizado.
*/
import java.util.Scanner;

public class MainContaBancaria {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double saldoInicial = scanner.nextDouble();
        ContaBancaria contaBancaria = new ContaBancaria(saldoInicial);

        double valorDeposito = scanner.nextDouble();
        contaBancaria.depositar(valorDeposito);
        contaBancaria.imprimirSaldo();

        double valorSaque = scanner.nextDouble();
        contaBancaria.sacar(valorSaque);
        contaBancaria.imprimirSaldo();

        scanner.close();
    }
}

class ContaBancaria {
    protected double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Deposito feito.");
    }

    public void sacar(double valor) {
        // Verifica se o saldo é suficiente para o saque
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque feito.");
        } else {
            System.out.println("Saldo insuficiente. Saque não realizado.");
        }
    }

    protected void imprimirSaldo() {
        System.out.printf("Saldo atual: %.1f\n", this.saldo);
    }
}