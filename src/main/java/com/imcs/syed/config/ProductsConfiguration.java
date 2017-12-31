package com.imcs.syed.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.imcs.syed.client.ProductsClient;

@Configuration
public class ProductsConfiguration {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.imcs.syed.wsdl");
		return marshaller;
	}

	@Bean
	public ProductsClient productsClient(Jaxb2Marshaller marshaller) {
		ProductsClient client = new ProductsClient();
		client.setDefaultUri("http://syed.imcs.com/Product");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}