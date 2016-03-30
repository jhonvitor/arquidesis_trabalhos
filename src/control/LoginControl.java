package control;

import model.service.UsuarioService;

public class LoginControl {

	public LoginControl() {

	}

	public String setUserLogin(String l, String p, String u) throws Exception {

		String loginAcesso = u + "-" + l + "-" + p;
		String arq = "login.txt";
		if(l.equals("Atendente") && p.equals("Atendente") && (u.equals("Atendente"))){
			return "ate";
		}
		String la = new UsuarioService().setReadFile(arq, loginAcesso);
		return la;		
	}

}
