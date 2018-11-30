package com.cts.fasttack.ih_sv.client.config;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author d.ishchenko
 */
@Validated
@ConfigurationProperties("spring.client.rest")
@Component
public class IssuerHostSvClientParameters {

	@NotEmpty
	private String address;

	@Value("${spring.client.tlsEnabled}")
	private Boolean tlsEnabled;

	private int connectionTimeoutInMills;

	private int readTimeoutInMills;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean isTlsEnabled() {
		return tlsEnabled;
	}

	public void setTlsEnabled(Boolean tlsEnabled) {
		this.tlsEnabled = tlsEnabled;
	}

	public int getConnectionTimeoutInMills() {
		return connectionTimeoutInMills;
	}

	public void setConnectionTimeoutInMills(int connectionTimeoutInMills) {
		this.connectionTimeoutInMills = connectionTimeoutInMills;
	}

	public int getReadTimeoutInMills() {
		return readTimeoutInMills;
	}

	public void setReadTimeoutInMills(int readTimeoutInMills) {
		this.readTimeoutInMills = readTimeoutInMills;
	}

}
