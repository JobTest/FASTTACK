package com.cts.fasttack.common.core.config;

import java.nio.charset.StandardCharsets;
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

public class PropertyDecryptor {

	public static String decrypt(String encrypted) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
		byte[] encryptedBytes = Base64.getDecoder().decode(encrypted);

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

		SecretKeySpec sk = new SecretKeySpec(new byte[] { (byte) 0x90, (byte) 0x12, (byte) 0x78, (byte) 0x34,
				(byte) 0x56, (byte) 0x09, (byte) 0x21, (byte) 0x87, (byte) 0x43, (byte) 0x65, (byte) 0x10, (byte) 0x29,
				(byte) 0x38, (byte) 0x83, (byte) 0x92, (byte) 0x01 }, "AES");

		cipher.init(Cipher.DECRYPT_MODE, sk,
				new IvParameterSpec(new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));

		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

		byte[] propertyBytes = new byte[decryptedBytes.length - 3];

		System.arraycopy(decryptedBytes, 3, propertyBytes, 0, propertyBytes.length);

		return new String(propertyBytes, StandardCharsets.UTF_8);
	}

}
