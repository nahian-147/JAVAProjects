
package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.GetCountriesResponse;
import com.example.consumingwebservice.wsdl.GetCountryByCountryCode;
import com.example.consumingwebservice.wsdl.GetCountryByCountryCodeResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumingWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(CountryClient quoteClient) {
		return args -> {
			String country = "BD";

			if (args.length > 0) {
				country = args[0];
			}
			GetCountryByCountryCodeResponse response = new GetCountryByCountryCodeResponse();
			System.out.println("   "+response.getGetCountryByCountryCodeResult());
			CountryClient client = new CountryClient();
			response = client.getCountryByCode(country);
			System.out.println(response.getGetCountryByCountryCodeResult());
			System.err.println(response.getGetCountryByCountryCodeResult());
		};
	}

}
