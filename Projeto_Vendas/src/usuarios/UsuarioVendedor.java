package usuarios;

public class UsuarioVendedor extends Usuario{

	private String cnpj;
	
	public UsuarioVendedor(String nome, String email, String senha, int idade, String cnpj) {
		super(2, nome, email, senha, idade);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public void listarUsuario() {
		System.out.println("********************************");
		System.out.println("Tipo: Vendedor");
		super.listarUsuario();
		System.out.println("CNPJ da empresa: " + cnpj);
		System.out.println("********************************");
	}
}
