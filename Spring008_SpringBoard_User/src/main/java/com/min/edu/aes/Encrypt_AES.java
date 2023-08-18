package com.min.edu.aes;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt_AES {

	public String transformation = "AES/CBC/PKCS5PADDING";
	private String key="01234567890123670123456789012367";
	private String iv=key.substring(0,16);
	
	// 비밀번호 암호화 AES
	public String encrypt(String txt) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		Cipher cipher = Cipher.getInstance(transformation);
		SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
		
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);
		
		byte[] encrypted = cipher.doFinal(txt.getBytes("UTF-8"));
		
		
		return Base64.getEncoder().encodeToString(encrypted);
	}
	
	// 비밀번호 복호화 AES
	public String decrypt(String txt) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		Cipher cipher = Cipher.getInstance(transformation);
		SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
		
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
		
		byte[] decrypted = Base64.getDecoder().decode(txt);
		byte[] decrypteded= cipher.doFinal(decrypted);
		
		
		return new String (decrypteded, "UTF-8");
	}
}
