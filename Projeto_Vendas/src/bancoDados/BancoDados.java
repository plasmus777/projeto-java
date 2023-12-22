package bancoDados;

public interface BancoDados {
	
	public abstract void adiciona(Object o);
	public abstract void remove(int id);
	public abstract void lista(int id);
	public abstract void listaTudo();
	public abstract Object busca(int id);
	public abstract int tamanho();
}
