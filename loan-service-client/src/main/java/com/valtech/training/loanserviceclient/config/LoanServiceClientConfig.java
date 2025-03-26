package com.valtech.training.loanserviceclient.config;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.loanservice.webservices.LoanServiceWS;

@Configuration
public class LoanServiceClientConfig {

	@Bean
	public LoanServiceWS createLoanSerivce() {
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(LoanServiceWS.class);
		proxy.setServiceName(new QName("http://webservices.loanservice.training.valtech.com/","LoanServiceWSImplService"));
		proxy.setAddress("http://localhost:8080/services/LoanService");
		return proxy.create(LoanServiceWS.class);
	}
}
