package com.example.config.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.eclipse.microprofile.config.spi.Converter;

public class StringToDateConverter implements Converter<LocalDate> {

	@Override
	public LocalDate convert(String value) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
		// convert String to LocalDate
		LocalDate localDate = LocalDate.parse(value, formatter);
		return localDate;
	}

}
