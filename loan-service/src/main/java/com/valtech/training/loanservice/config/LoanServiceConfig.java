package com.valtech.training.loanservice.config;


import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.loanservice.services.LoanService;
import com.valtech.training.loanservice.webservices.LoanServiceWSImpl;

@Configuration
public class LoanServiceConfig {

	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint loanServiceWS(LoanService loanService) {
		EndpointImpl endPoint = new EndpointImpl(bus,new LoanServiceWSImpl(loanService));
		endPoint.setAddress("/LoanService");
		endPoint.publish();
		return endPoint;
	}
}
