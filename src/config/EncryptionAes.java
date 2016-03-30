package config;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionAes {

	public EncryptionAes() {
	}

	// Gera uma chave criptografica de 128bits aleatória
	public byte[] key() throws NoSuchAlgorithmException {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		SecretKey key = keyGen.generateKey();
		return key.getEncoded();
	}

	// Encripta uma mensagem usando AES para uma dada chave
	public byte[] encode(byte[] input, byte[] key)
			throws NoSuchAlgorithmException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException,
			NoSuchPaddingException {
		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(input);
		return encrypted;
	}

	// Retorna o valor original de uma mensagem criptgrafada em AES
	public byte[] decode(byte[] input, byte[] key)
			throws NoSuchAlgorithmException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException,
			NoSuchPaddingException {
		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] decrypted = cipher.doFinal(input);
		return decrypted;
	}

	// Converte uma mensagem criptografada para uma string de sua representação
	// hexadecimal.
	public String fromHex(byte[] hex) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < hex.length; i++) {
			sb.append(Integer.toString((hex[i] & 0xff) + 0x100, 16)
					.substring(1));
		}
		return sb.toString();
	}

	// Converte uma representação hexadecimal para seus bytes hexadecimal (valor
	// encriptado)
	public byte[] toHex(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
					.digit(s.charAt(i + 1), 16));
		}
		return data;
	}

	// Corrige o tamanho de uma String para multiplo de 16
	public String nullPadString(String original) {
		StringBuffer output = new StringBuffer(original);
		int remain = output.length() % 16;
		if (remain != 0) {
			remain = 16 - remain;
			for (int i = 0; i < remain; i++)
				output.append((char) 0);
		}
		return output.toString();
	}
}
