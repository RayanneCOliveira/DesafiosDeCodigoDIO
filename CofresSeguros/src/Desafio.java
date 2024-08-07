/*
Descrição

Você foi contratado para desenvolver um sistema de cofres seguros.
O objetivo é criar dois tipos de cofres: um Cofre Digital, que é aberto por senha, e um Cofre Físico,
que é aberto por chave.


Entrada

O programa irá solicitar ao usuário que digite o tipo de cofre a ser criado: "digital" ou "físico".
Se for escolhido o tipo "digital", o programa irá solicitar a senha e a confirmação de senha do cofre digital
(ambas com apenas números). Caso seja escolhido o tipo "físico", não é necessário nenhuma outra entrada.


Saída

O programa irá exibir as informações do cofre criado. Para o Cofre Digital, será exibido o tipo e o
método de abertura (senha). Para o Cofre Físico, será exibido apenas o tipo e o método de abertura (chave).
*/

import java.util.Scanner;

abstract class Cofre {
    protected String tipo;
    protected String metodoAbertura;

    public Cofre(String tipo, String metodoAbertura) {
        this.tipo = tipo;
        this.metodoAbertura = metodoAbertura;
    }

    public void imprimirInformacoes() {
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Metodo de abertura: " + this.metodoAbertura);
    }
}

class CofreDigital extends Cofre {

    private int senha;

    public CofreDigital(int senha) {
        super("Cofre Digital", "Senha");
        this.senha = senha;
    }

    public boolean validarSenha(int confirmacaoSenha) {
        return confirmacaoSenha == this.senha;
    }
}

class CofreFisico extends Cofre {

    public CofreFisico() {
        super("Cofre Fisico", "Chave");
    }

}

public class Desafio {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String tipoCofre = scanner.nextLine();

        switch (tipoCofre.toLowerCase()) {
            case "digital":
                int senhaDigital = scanner.nextInt();
                int confirmarSenhaDigital = scanner.nextInt();
                CofreDigital cofreDigital = new CofreDigital(senhaDigital);

                if (cofreDigital.validarSenha(confirmarSenhaDigital)) {
                    cofreDigital.imprimirInformacoes();
                    System.out.println("Cofre aberto!");
                    break;
                } else {
                    cofreDigital.imprimirInformacoes();
                    System.out.println("Senha incorreta!");
                    break;
                }
            case "fisico":
                CofreFisico cofreFisico = new CofreFisico();
                cofreFisico.imprimirInformacoes();
                break;
        }
        scanner.close();
    }
}