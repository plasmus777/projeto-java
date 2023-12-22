package main;

import java.util.Scanner;

public class SistemaVendas {

	private static Scanner s = new Scanner(System.in);
	private static String email, senha, cpf, cnpj, nomeProduto;
	private static int idUsuarioLogado, opcao, tipoUsuario, idade, idUsuario, quantProduto;
	private static float precoProduto;
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("\n*************************************");
			System.out.println("          Sistema de Vendas");
			System.out.println("*************************************");
			System.out.println("Por favor, digite sua opção (1 - 10):");
			System.out.println("1 - Cadastrar usuário");
			System.out.println("2 - Fazer login");
			System.out.println("3 - Listar todos os usuários");
			System.out.println("4 - Sair");
			opcao = s.nextInt();
			
			switch(opcao) {
				case 1:
					cadastroUsuario();
					break;
			
				case 2:
					
					loginUsuario();
					break;
					
				case 3:
					
					
				case 4:
					System.out.println("Obrigado por utilizar o sistema!");
					s.close();
					System.exit(0);
					
				default:
					System.out.println("A opção selecionada não existe!");
			}
		}
	}

	//Cria um usuário no sistema de compras e vendas
	private static void cadastroUsuario() {
		System.out.println("\n*************************************");
		System.out.println("        Cadastro de usuário");
		System.out.println("*************************************");
		System.out.println("Por favor, digite seu e-mail:");
		s.skip("\\R?");
		email = s.nextLine();
		System.out.println("Por favor, digite sua senha:");
		s.skip("\\R?");
		senha = s.nextLine();
		System.out.println("Por favor, digite sua idade:");
		idade = s.nextInt();
		System.out.println("Por favor, digite o tipo da conta criada (1-Comprador, 2-Vendedor)");
		tipoUsuario = s.nextInt();
		
		do {
			if(tipoUsuario == 1) {
				System.out.println("Por favor, digite seu CPF:");
				s.skip("\\R?");
				cpf = s.nextLine();
			} else if(tipoUsuario == 2) {
				System.out.println("Por favor, digite o CNPJ de sua empresa:");
				s.skip("\\R?");
				cnpj = s.nextLine();
			}
		} while(tipoUsuario > 2 || tipoUsuario < 1);
	}
	
	//Configura a variável idUsuarioLogado para definir o usuário atual no sistema, e permite compras ou vendas dependendo do tipo do usuário
	public static void loginUsuario() {
		
	}
	
	//O usuário logado pode realizar compras
	public static void comprar() {
		
	}
	
	//O usuário logado pode realizar vendas
	public static void vender() {
		
	}
}
