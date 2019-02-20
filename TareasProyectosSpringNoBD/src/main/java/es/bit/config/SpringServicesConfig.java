/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package es.bit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.bit.persistence.UsuariosManager;

// Declare as a configuration class
@Configuration
public class SpringServicesConfig {
	
	@Bean
	public UsuariosManager usuariosManager() throws Exception {		
		return UsuariosManager.getInstance();
	}


}