package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class ModelConfiguration {

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
}