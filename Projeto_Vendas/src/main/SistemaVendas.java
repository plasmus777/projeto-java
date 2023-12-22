package main;

import java.util.Scanner;

import bancoDados.BancoDadosProdutos;
import bancoDados.BancoDadosUsuarios;
import produtos.Produto;
import usuarios.Usuario;
import usuarios.UsuarioComprador;
import usuarios.UsuarioVendedor;

public class SistemaVendas {

	private static Scanner s = new Scanner(System.in);
	private static String nome, email, senha, cpf, cnpj, nomeProduto;
	private static int opcao, tipoUsuario, idade, quantProduto, idProduto;
	private static float precoProduto, oferta;
	
	private static BancoDadosUsuarios bdU = new BancoDadosUsuarios();
	private static BancoDadosProdutos bdP = new BancoDadosProdutos();
	
	private static Usuario usuarioLogado;
	
	public static void main(String[] args) {
		
		while(true) {
			if(usuarioLogado == null) {
				System.out.println("\n*************************************");
				System.out.println("          Sistema de Vendas");
				System.out.println("*************************************");
				System.out.println("Por favor, digite sua opção (1 - 5):");
				System.out.println("1 - Cadastrar usuário");
				System.out.println("2 - Fazer login");
				System.out.println("3 - Listar todos os usuários");
				System.out.println("4 - Listar todos os produtos da loja");
				System.out.println("5 - Sair");
				opcao = s.nextInt();
				
				switch(opcao) {
					case 1:
						cadastroUsuario();
						break;
				
					case 2:
						
						loginUsuario();
						break;
						
					case 3:
						bdU.listaTudo();
						break;
						
					case 4:
						bdP.listaTudo();
						break;
					case 5:
						System.out.println("Obrigado por utilizar o sistema!");
						s.close();
						System.exit(0);
						
					default:
						System.out.println("A opção selecionada não existe!");
				}
			} else {
				if(usuarioLogado.getTipo() == 1) {
					comprar();
				} else if(usuarioLogado.getTipo() == 2) {
					vender();
				}
			}
		}
	}

	//Cria um usuário no sistema de compras e vendas
	private static void cadastroUsuario() {
		System.out.println("\n*************************************");
		System.out.println("        Cadastro de usuário");
		System.out.println("*************************************");
		System.out.println("Por favor, digite seu nome:");
		s.skip("\\R?");
		nome = s.nextLine();
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
				
				UsuarioComprador uC = new UsuarioComprador(nome, email, senha, idade, cpf);
				bdU.adiciona(uC);
				System.out.println("Cadastro realizado com sucesso!");
				
				usuarioLogado = uC;
			} else if(tipoUsuario == 2) {
				System.out.println("Por favor, digite o CNPJ de sua empresa:");
				s.skip("\\R?");
				cnpj = s.nextLine();
				UsuarioVendedor uV = new UsuarioVendedor(nome, email, senha, idade, cnpj);
				bdU.adiciona(uV);
				System.out.println("Cadastro realizado com sucesso!");
				
				usuarioLogado = uV;
			}
		} while(tipoUsuario > 2 || tipoUsuario < 1);
	}
	
	//Configura a variável idUsuarioLogado para definir o usuário atual no sistema, e permite compras ou vendas dependendo do tipo do usuário
	public static void loginUsuario() {
		System.out.println("\n*************************************");
		System.out.println("                 Login");
		System.out.println("*************************************");
		System.out.println("Por favor, digite seu e-mail: ");
		s.skip("\\R?");
		email = s.nextLine();
		System.out.println("Por favor, digite sua senha:");
		s.skip("\\R?");
		senha = s.nextLine();
		
		Usuario u = (Usuario) bdU.busca(bdU.fazLogin(email, senha));
		if(u != null && u instanceof Usuario){
			usuarioLogado = u;
			System.out.println("\n*************************************");
			System.out.println("Login para o usuário " + u.getNome() + " feito com sucesso!");
			System.out.println("\n*************************************");
		} else {
			System.out.println("\n*************************************");
			System.out.println("O usuário digitado está incorreto, a senha está incorreta ou o usuário não existe!");
			System.out.println("\n*************************************");
		}
	}
	
	//Cria um produto no sistema de compras e vendas
	public static void cadastrarProduto() {
		System.out.println("\n*************************************");
		System.out.println("        Cadastro de produto");
		System.out.println("*************************************");
		System.out.println("Por favor, digite o nome do produto:");
		s.skip("\\R?");
		nomeProduto = s.nextLine();
		System.out.println("Por favor, a quantidade em estoque:");
		quantProduto = s.nextInt();
		System.out.println("Por favor, digite o preço por unidade do produto (R$):");
		precoProduto = s.nextFloat();
		
		Produto p = new Produto(nomeProduto, quantProduto, precoProduto, usuarioLogado.getId());
		bdP.adiciona(p);
	}
	
	//O usuário logado pode realizar compras
	public static void comprar() {
		System.out.println("\n*************************************");
		System.out.println("          Menu do Comprador");
		System.out.println("*************************************");
		System.out.println("Por favor, digite sua opção (1 - 4):");
		System.out.println("1 - Comprar produto");
		System.out.println("2 - Buscar produtos");
		System.out.println("3 - Listar todos os produtos da loja");
		System.out.println("4 - Logout");
		opcao = s.nextInt();
		
		switch(opcao) {
			case 1:
				System.out.println("\n*************************************");
				System.out.println("Por favor, digite o ID do produto a ser comprado (verifique o ID com uma busca antes):");
				idProduto = s.nextInt();
				Produto p = (Produto)bdP.busca(idProduto);
				if(p != null && p instanceof Produto) {
					System.out.println("**********************************");
					System.out.println("Você está comprando: " + p.getNome());
					System.out.println("Preço por unidade: " + p.getPreco());
					System.out.println("Total no estoque: " + p.getQuantidade() + " unidades");
					System.out.println("**********************************");
					System.out.println("Digite a quantidade que deseja comprar:");
					quantProduto = s.nextInt();
					System.out.println("Digite sua oferta para pagamento (R$):");
					oferta = s.nextInt();
					
					p.comprarProduto(oferta, quantProduto);
					System.out.println("*************************************");
				}
				
				break;
		
			case 2:
				System.out.println("\n*************************************");
				System.out.println("Por favor, digite o termo de busca:");
				s.skip("\\R?");
				nomeProduto = s.nextLine();
				bdP.buscarProdutos(nomeProduto);
				System.out.println("*************************************");
				break;
				
			case 3:
				System.out.println("\n*************************************");
				System.out.println("         Produtos em estoque");
				System.out.println("*************************************");
				bdP.listaTudo();
				System.out.println("*************************************");
				break;
				
			case 4:
				System.out.println("\n*************************************");
				System.out.println("Saindo do usuário " + usuarioLogado.getNome() + "...");
				usuarioLogado = null;
				System.out.println("*************************************");
				break;
				
			default:
				System.out.println("\n*************************************");
				System.out.println("A opção selecionada não existe!");
				System.out.println("*************************************");
		}
	}
	
	//O usuário logado pode realizar vendas
	public static void vender() {
		System.out.println("\n*************************************");
		System.out.println("          Menu do Vendedor");
		System.out.println("*************************************");
		System.out.println("Por favor, digite sua opção (1 - 4):");
		System.out.println("1 - Anunciar produto");
		System.out.println("2 - Reabastecer produto");
		System.out.println("3 - Remover produto");
		System.out.println("4 - Listar todos os meus produtos");
		System.out.println("5 - Listar todos os produtos da loja");
		System.out.println("6 - Logout");
		opcao = s.nextInt();
		
		switch(opcao) {
			case 1:
				cadastrarProduto();
				break;
				
			case 2:
				System.out.println("\n*************************************");
				System.out.println("Por favor, digite o ID do produto a ser reabastecido (verifique o ID com uma busca antes):");
				idProduto = s.nextInt();
				System.out.println("Por favor, digite o número de unidades para adicionar no estoque:");
				quantProduto = s.nextInt();
				System.out.println("*************************************");
				
				Produto p = (Produto) bdP.busca(idProduto);
				if(p != null && p instanceof Produto) {
					int antes = p.getQuantidade();
					p.adicionar(quantProduto);
					int depois = p.getQuantidade();
					System.out.println("Estoque do produto \"" + p.getNome() + "\" foi aumentado de " + antes + "unidades para " + depois + " unidades.");
				} else {
					System.out.println("Ocorreu um erro ao reabastecer o estoque.");
				}
				System.out.println("*************************************");
				break;
				
			case 3:
				System.out.println("\n*************************************");
				System.out.println("Por favor, digite o ID do produto a ser removido (verifique o ID com uma busca antes):");
				idProduto = s.nextInt();
				Produto p1 = (Produto)bdP.busca(idProduto);
				if(p1 != null && p1 instanceof Produto) {
					bdP.remove(idProduto);
				} else {
					System.out.println("Ocorreu um erro ao remover o produto.");
				}
				System.out.println("*************************************");
				break;
				
			case 4:
				System.out.println("\n*************************************");
				System.out.println("            Seus produtos");
				System.out.println("*************************************");
				bdP.buscarProdutos(usuarioLogado.getId());
				System.out.println("*************************************");
				break;
				
			case 5:
				System.out.println("\n*************************************");
				System.out.println("          Produtos do estoque");
				System.out.println("*************************************");
				bdP.listaTudo();
				System.out.println("*************************************");
				break;
				
			case 6:
				System.out.println("\n*************************************");
				System.out.println("Saindo do usuário " + usuarioLogado.getNome() + "...");
				usuarioLogado = null;
				System.out.println("*************************************");
				break;
				
			default:
				System.out.println("\n*************************************");
				System.out.println("A opção selecionada não existe!");
				System.out.println("*************************************");
		}
	}
}
