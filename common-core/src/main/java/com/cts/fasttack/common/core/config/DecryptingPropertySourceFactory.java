package com.cts.fasttack.common.core.config;

import java.io.IOException;

import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

public class DecryptingPropertySourceFactory extends DefaultPropertySourceFactory {

	@Override
	public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {

		return name != null ? new DecryptingPropertySource(name, resource) : new DecryptingPropertySource(resource);
	}

}
