package bancoDados;

import java.util.ArrayList;

import produtos.Produto;

public class BancoDadosProdutos implements BancoDados{

	ArrayList<Produto> banco = new ArrayList<Produto>();
	
private int cont = 0;
	
	public BancoDadosProdutos() {
		System.out.println("O banco de dados de produtos foi criado!");
	}
	
	@Override
	public void adiciona(Object o) {
		if(o != null && o instanceof Produto) {
			Produto p = (Produto)o;
			p.setId(++cont);
			banco.add(p);
			System.out.println("O produto com ID = " + p.getId() + " foi adicionado!");
		} else {
			System.out.println("O objeto buscado não existe ou não é um produto!");
			throw new IllegalArgumentException("O banco de dados foi incapaz de inserir um produto adequadamente.");
		}
	}

	@Override
	public void remove(int id) {
		Object o = busca(id);
		if(o != null && o instanceof Produto) {
			Produto p = (Produto) o;
			banco.remove(p);
			System.out.println("O produto com ID = " + p.getId() + " foi removido!");
		} else {
			System.out.println("O objeto buscado não existe ou não é um produto!");
		}
	}

	@Override
	public void lista(int id) {
		if(tamanho() == 0) {
			System.out.println("O banco de dados de produtos está vazio!");
			return;
		}
		Object o = busca(id);
		if(o != null && o instanceof Produto) {
			Produto p = (Produto) o;
			p.listarProduto();
		} else {
			System.out.println("O objeto buscado não existe ou não é um produto!");
		}
	}

	@Override
	public void listaTudo() {
		if(tamanho() == 0) {
			System.out.println("O banco de dados de produtos está vazio!");
		}
		for(Produto p: banco) {
			p.listarProduto();
		}
	}
	
	@Override
	public Object busca(int id) {
		for(Produto p: banco) {
			if(p.getId() == id)return p;
		}
		return null;
	}

	@Override
	public int tamanho() {
		return banco.size();
	}

	public void buscarProdutos(String busca) {
		for(Produto p: banco) {
			if(p.getNome().toLowerCase().contains(busca.toLowerCase())) {
				p.listarProduto();
			}
		}
	}
	
	public void buscarProdutos(int vendedor) {
		for(Produto p: banco) {
			if(p.getIdVendedor() == vendedor) {
				p.listarProduto();
			}
		}
	}
	
}
