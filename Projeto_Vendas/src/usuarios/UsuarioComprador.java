package usuarios;

public class UsuarioComprador extends Usuario{

	private String cpf;
	
	public UsuarioComprador(String nome, String email, String senha, int idade, String cpf) {
		super(1, nome, email, senha, idade);
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public void listarUsuario() {
		System.out.println("********************************");
		System.out.println("Tipo: Comprador");
		super.listarUsuario();
		System.out.println("CPF: " + cpf);
		System.out.println("********************************");
	}
}
