package usuarios;

public abstract class Usuario {
	protected String nome, email, senha;
	
	protected int id, tipo, idade;
	
	public Usuario(int tipo, String nome, String email, String senha, int idade) {
		this.tipo = tipo;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void listarUsuario() {
		System.out.println("Usuário com ID = " + id + ":");
		System.out.println("Nome: " + nome);
		System.out.println("E-mail: " + email);
		System.out.println("Idade: " + idade);
	}
}
