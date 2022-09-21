package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}

	public static void operacoes() {

		System.out.println("------------------------------------------------------");
		System.out.println("-------------Bem vindos a nossa Ag�ncia---------------");
		System.out.println("------------------------------------------------------");
		System.out.println("***** Selecione uma opera��o que deseja realizar *****");
		System.out.println("------------------------------------------------------");
		System.out.println("|   Op��o 1 - Criar conta   |");
		System.out.println("|   Op��o 2 - Depositar     |");
		System.out.println("|   Op��o 3 - Sacar         |");
		System.out.println("|   Op��o 4 - Transferir    |");
		System.out.println("|   Op��o 5 - Listar        |");
		System.out.println("|   Op��o 6 - Sair          |");

		int operacao = input.nextInt();

		switch (operacao) {
		case 1:
			criarConta();
			break;

		case 2:
			depositar();
			break;

		case 3:
			sacar();
			break;

		case 4:
			transferir();
			break;

		case 5:
			listarContas();
			break;

		case 6:
			System.out.println("Flw � n�is, Thank you for using the BruBank agency");
			System.exit(0); // para o sistema

		default:
			System.out.println("Op��o inv�lida!");
			operacoes();
			break;

		}
	}

	public static void CriarConta() {
		// System.out.println("Voc� est� criando uma conta\n");

		System.out.println("\nNome: ");
		String nome = input.next();

		System.out.println("\nCPF: ");
		String cpf = input.next();

		System.out.println("Email: ");
		String email = input.next();

		Pessoa cliente = new Pessoa(nome, cpf, email);

		Conta conta = new Conta(cliente);

		contasBancarias.add(conta);
		System.out.println("--- Sua conta foi criada com sucesso! ---");

		operacoes();

	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta)
					;
				conta = c;
			}
		}
		return conta;
	}

	public static void depositar() {
		System.out.println("N�mero da conta: ");
		int numeroConta = input.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println(" Qual valor deseja depositar? ");
			Double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println(" Valor depositado com sucesso! ");
		} else {
			System.out.println(" Conta n�o encontrada! ");
		}
		operacoes();

	}
}
