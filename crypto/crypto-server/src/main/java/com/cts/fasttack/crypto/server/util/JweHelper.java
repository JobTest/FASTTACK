package com.cts.fasttack.crypto.server.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.cts.fasttack.common.core.exception.CryptographyException;
import com.cts.fasttack.common.core.util.JsonUtil;

public class JweHelper {

	public static String extractKid(String jweJws) {
		try {
			String[] parts = jweJws.split("\\.");

			if (parts.length != 3) {
				throw new CryptographyException("Invalid JWS format: must consist of 3 parts delimited by dots");
			}

			String jwe = new String(Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8);

			parts = jwe.split("\\.");

			if (parts.length != 5) {
				throw new CryptographyException(
						"Invalid JWE under JWS format: must consist of 5 parts delimited by dots");
			}

			String jweHeaderJson = new String(Base64.getUrlDecoder().decode(parts[0]), StandardCharsets.UTF_8);

			JweHeader jweHeader = JsonUtil.fromJson(jweHeaderJson, JweHeader.class);

			return jweHeader.getKid();
		} catch (CryptographyException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new CryptographyException(ex);
		}
	}

	private static class JweHeader {
		private String kid;
		
		public String getKid() {
			return kid;
		}
		
		@SuppressWarnings("unused")
		public void setKid(String kid) {
			this.kid = kid;
		}
	}

}
