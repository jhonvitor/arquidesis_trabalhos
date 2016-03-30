package model.service;

import java.util.ArrayList;
import java.util.Arrays;

import model.entidade.AlunoEntidade;
import config.Constants;
import config.EncryptionAes;
import dao.UsuarioDao;

public class UsuarioService {
	private UsuarioDao sf;
	private EncryptionAes enc;

	private byte[] bkey = null;

	public UsuarioService() throws Exception {
		sf = new UsuarioDao();
		enc = new EncryptionAes();
		bkey = Constants.bkey;
	}

	// LER O TXT
	public String setReadFile(String arq, String loginAcesso) throws Exception {
		ArrayList<String> rt = new ArrayList<String>();
		rt = sf.readTextFile(sf.getFile(arq));
		String lvet[] = new String[rt.size()];

		String login = "";
		boolean permicao = false;

		for (int i = 0; i < rt.size(); i++) {

			login = rt.get(i);
			byte[] msgEnc = enc.toHex(login);
			byte[] msg = enc.decode(msgEnc, bkey);
			String mensagem = new String(msg).trim();
			lvet[i] = mensagem; 
		}
		
		// REALIZA A BUSCA BINARIA PARA VERIFICACAO DOS LOGINS
		Arrays.sort(lvet);
		if (Arrays.binarySearch(lvet, loginAcesso) >= 0){
			permicao = true;
			login = lvet[Arrays.binarySearch(lvet, loginAcesso)];
		}

		if (permicao) {
			String vet[] = login.split("-");
			String usu = (String) vet[0];
			if (usu.equals("Atendente")) {
				return "ate";
			} else if (usu.equals("Aluno")) {
				return "alu";
			} else if (usu.equals("Adminidtrador")) {
				return "adm";
			} else
				return "";

		} else {
			return "";
		}
	}

	// ESCREVEE NO TXT O LOGIN CRIPTOGRAFADO AES
	public String setWriteFile(String arq, AlunoEntidade al, String usu)
			throws Exception {
		String result = "ok";
		String login = usu + "-" + al.getCpf() + "-"
				+ al.getCpf().substring(0, 4);

		byte[] msgEnc = enc.encode(enc.nullPadString(login).getBytes(), bkey);
		String mensagem = enc.fromHex(msgEnc);

		if (!sf.exists(arq)) {
			if (!sf.createFile(arq)) {
				result = "Arquivo TXT inexistente/nErro ao tentar criar o arquivo";
			} else {
				if (!sf.writeTextFile(mensagem + "\r\n", sf.getFile(arq))) {
					result = "O Login do aluno cadastrado não pode ser criado";
				}
			}
		} else if (!sf.writeTextFile(mensagem + "\r\n", sf.getFile(arq))) {
			result = "O Login do aluno cadastrado não pode ser criado";
		}
		return result;
	}

}
