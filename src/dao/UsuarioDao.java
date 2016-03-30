package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UsuarioDao {

	public UsuarioDao() {
	}

	// Metodo acesso File
	public File getFile(String path) {
		File f = new File(path);
		return f;
	}

	// Verifica Existencia do Arquivo
	public boolean exists(String path) {
		File f = new File(path);
		return f.exists();
	}

	// Cria o Arquivo
	public boolean createFile(String path) {
		boolean result = false;
		File f = new File(path);
		try {
			f.createNewFile();
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	// Escreve no Arquivo
	public boolean writeTextFile(String conteudo, File arquivo) {

		boolean retorno = false;
		try {
			FileWriter writer = new FileWriter(arquivo, true);
			writer.write(conteudo);
			writer.close();
			retorno = true;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	// LER O ARQUIVO TXT
	public ArrayList<String> readTextFile(File arquivo) {
		ArrayList<String> content = new ArrayList<String>();
		try {
			String line = "";
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			line = br.readLine();
			while (line != null) {
				line = line.trim().replace("\n", "").replace("\r", "");
				content.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	// Apaga o arquivo
	public boolean deletFile(String arquivo) {
		boolean result = false;
		try {
			File f = new File(arquivo);
			f.delete();
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
