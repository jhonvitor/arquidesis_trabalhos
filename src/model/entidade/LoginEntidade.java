package model.entidade;

public class LoginEntidade {

	private String login, usuario, senha;

	public LoginEntidade() {

		this("", "", "");

	}

	public LoginEntidade(String l, String u, String s) {

		setLogin(l);
		setUsuario(u);
		setSenha(s);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
