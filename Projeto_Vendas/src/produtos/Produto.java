package produtos;

public class Produto {
	
	private String nome;
	private int id, quantidade;
	private float preco;
	
	public Produto(String nome, int quantidade, float preco){
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public void adicionar(int quant) {
		setQuantidade(quantidade + quant);
		System.out.println("*******************************");
		System.out.println("O produto " + nome + " teve reabastecimento de estoque em " + quant + " unidades.");
		System.out.println("*******************************");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public float getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public boolean podePagar(float oferta, int quant) {
		if(oferta >= preco*quant && quant <= quantidade)return true;
		else return false;
	}
	
	public void comprarProduto(float oferta, int quant){
		float total = preco*quant;
		float troco = oferta - total;
		if(podePagar(oferta, quant)) {
			quantidade -= quant;
			
			System.out.println("**********************************");
			System.out.println("O produto " + nome + " teve " + quant + " unidades vendidas (R$ " + preco + " cada),"
					+ " somando um total de R$ " + total + ". O troco será de R$ " + troco + ".");
			System.out.println("**********************************");
		} else {
			System.out.println("**********************************");
			if(oferta < total)System.out.println("O valor pago não é suficiente para realizar a compra!");
			if(quant > quantidade)System.out.println("Não há unidades suficientes no estoque!");
			System.out.println("**********************************");
		}
	}
	
	public void listarProduto() {
		System.out.println("*******************************");
		System.out.println("ID do produto: " + id);
		System.out.println("Produto: " + nome);
		System.out.println("Quantidade em estoque: " + quantidade);
		System.out.println("Preço por unidade: " + preco);
		System.out.println("*******************************");
	}
	
}
