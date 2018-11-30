package com.cts.fasttack.common.core.config;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.ResourcePropertySource;

public class DecryptingPropertySource extends ResourcePropertySource {

	public DecryptingPropertySource(String name, EncodedResource resource) throws IOException {
		super(name, resource);
	}

	public DecryptingPropertySource(EncodedResource resource) throws IOException {
		super(resource);
	}

	public DecryptingPropertySource(String name, Resource resource) throws IOException {
		super(name, resource);
	}

	public DecryptingPropertySource(Resource resource) throws IOException {
		super(resource);
	}

	public DecryptingPropertySource(String name, String location, ClassLoader classLoader) throws IOException {
		super(name, location, classLoader);
	}

	public DecryptingPropertySource(String location, ClassLoader classLoader) throws IOException {
		super(location, classLoader);
	}

	public DecryptingPropertySource(String name, String location) throws IOException {
		super(name, location);
	}

	public DecryptingPropertySource(String location) throws IOException {
		super(location);
	}

	@Override
	public Object getProperty(String name) {
		Object result;

		result = super.getProperty(name);

		if (result != null) {
			if (result instanceof String) {
				String stringValue = (String) result;

				if (stringValue.startsWith("ENC(") && stringValue.endsWith(")")) {
					try {
						result = PropertyDecryptor.decrypt(stringValue.substring(4, stringValue.length() - 1));
					} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
							| IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException ex) {
						throw new RuntimeException("Could not decrypt encrypted property: name = '" + name
								+ "', value = '" + stringValue + "'");
					}
				}
			}
		}

		return result;
	}

}
