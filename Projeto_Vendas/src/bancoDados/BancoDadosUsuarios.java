package bancoDados;

import java.util.ArrayList;

import usuarios.Usuario;

public class BancoDadosUsuarios implements BancoDados{

	ArrayList<Usuario> banco = new ArrayList<Usuario>();
	
	private int cont = 0;
	
	public BancoDadosUsuarios() {
		System.out.println("O banco de dados de usuários foi criado!");
	}
	
	@Override
	public void adiciona(Object o) {
		if(o != null && o instanceof Usuario) {
			Usuario u = (Usuario)o;
			u.setId(++cont);
			banco.add(u);
			System.out.println("O usuário com ID = " + u.getId() + " foi adicionado!");
		} else {
			System.out.println("O objeto buscado não existe ou não é um usuário!");
			throw new IllegalArgumentException("O banco de dados foi incapaz de inserir um usuário adequadamente.");
		}
	}

	@Override
	public void remove(int id) {
		Object o = busca(id);
		if(o != null && o instanceof Usuario) {
			Usuario u = (Usuario) o;
			banco.remove(u);
			System.out.println("O usuário com ID = " + u.getId() + " foi removido!");
		} else {
			System.out.println("O objeto buscado não existe ou não é um usuário!");
		}
	}

	@Override
	public void lista(int id) {
		if(tamanho() == 0) {
			System.out.println("O banco de dados de usuários está vazio!");
			return;
		}
		
		Object o = busca(id);
		if(o != null && o instanceof Usuario) {
			Usuario u = (Usuario) o;
			u.listarUsuario();
		} else {
			System.out.println("O objeto buscado não existe ou não é um usuário!");
		}
	}

	@Override
	public void listaTudo() {
		if(tamanho() == 0) {
			System.out.println("O banco de dados de usuários está vazio!");
			return;
		}
		
		for(Usuario u: banco) {
			u.listarUsuario();
		}
	}
	
	@Override
	public Object busca(int id) {
		for(Usuario u: banco) {
			if(u.getId() == id)return u;
		}
		return null;
	}

	@Override
	public int tamanho() {
		return banco.size();
	}
	
	public int fazLogin(String email, String senha) {
		for(Usuario u: banco) {
			if(u.getEmail().equals(email) && u.getSenha().equals(senha)) {
				return u.getId();
			}
		}
		return 0;
	}

}
