package com.concretepage.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WSConfiguration.class);
		ctx.setServletContext(servletContext);
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(ctx);
		servlet.setTransformWsdlLocations(true);
		Dynamic dynamic = servletContext.addServlet("dispatcher", servlet);
		dynamic.addMapping("/soapws/*");
		dynamic.setLoadOnStartup(1);
	}
}