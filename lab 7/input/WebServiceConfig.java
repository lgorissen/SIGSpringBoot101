package com.dronebuzzers.soap.service;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.SimpleXsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
			ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/parts/*");
	}

	@Bean(name = "parts")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema partsSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("PartsPort");
		wsdl11Definition.setLocationUri("/parts/soap");
		wsdl11Definition.setTargetNamespace("http://dronebuzzers.com/parts/soap");
		wsdl11Definition.setSchema(partsSchema);
		wsdl11Definition.setCreateSoap11Binding(false); // no SOAP 1.1
		wsdl11Definition.setCreateSoap12Binding(true); // SOAP 1.2
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema partsSchema() {
		return new SimpleXsdSchema(new ClassPathResource("parts.xsd"));
	}

	@Bean
	public SaajSoapMessageFactory messageFactory() {
		SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
		messageFactory.setSoapVersion(SoapVersion.SOAP_12);
		return messageFactory;
	}
}
