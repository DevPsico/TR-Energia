package com.ericsontrenergia.ericsontrenergia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	 @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	            .info(new Info()
	                .title("API de Usuários")
	                .version("1.0")
	                .description("Documentação da API para gerenciamento de usuários")
	                .contact(new Contact()
	                    .name("Seu Nome")
	                    .email("seuemail@exemplo.com")));
	    }
}