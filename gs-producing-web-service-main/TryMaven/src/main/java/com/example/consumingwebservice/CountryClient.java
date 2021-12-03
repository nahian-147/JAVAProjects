
package com.example.consumingwebservice;

import com.example.consumingwebservice.wsdl.GetCountryByCountryCode;
import com.example.consumingwebservice.wsdl.GetCountryByCountryCodeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

//import com.example.consumingwebservice.wsdl.GetCountryRequest;
//import com.example.consumingwebservice.wsdl.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

	public GetCountryByCountryCodeResponse getCountryByCode(String country){
		GetCountryByCountryCode request = new GetCountryByCountryCode();
		request.setCountryCode(country);

		log.info("Requesting Country Name for "+country);

		GetCountryByCountryCodeResponse response = (GetCountryByCountryCodeResponse) getWebServiceTemplate()
				.marshalSendAndReceive("https://www.swi-prolog.org/pack/file_details/wsdl/examples/country.wsdl",request,
						new SoapActionCallback("https://www.swi-prolog.org/pack/file_details/wsdl/examples/country.wsdl"));
		return response;
	}
//	public GetCountryResponse getCountry(String country) {
//
//		GetCountryRequest request = new GetCountryRequest();
//		request.setName(country);
//
//		log.info("Requesting location for " + country);
//
//		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
//				.marshalSendAndReceive("https://www.swi-prolog.org/pack/file_details/wsdl/examples/country.wsdl", request,
//						new SoapActionCallback(
//								"http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
//
//		return response;
//	}

}
