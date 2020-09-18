package com.example.config.source;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.microprofile.config.spi.ConfigSource;

/*
 * 
 *  ordinal value
 *  --------------------------
 * 
 *  system properties     ==> 400
 *  environment variable  ==> 300
 * 
 */

public class InMemoryConfigSource implements ConfigSource {

	Map<String, String> props = new HashMap<String, String>();

	public InMemoryConfigSource() {
		props.put("greeting.message", "InMemmoryConfigSource_Hello");
	}

	@Override
	public Map<String, String> getProperties() {
		return props;
	}

	@Override
	public String getValue(String propertyName) {
		return props.get(propertyName);
	}

	@Override
	public String getName() {
		return "InMemoryConfigSource";
	}

	@Override
	public int getOrdinal() {
		return 500;
	}

}
