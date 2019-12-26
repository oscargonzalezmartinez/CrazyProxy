package org.ogm.crazyproxy;

import org.ogm.crazyproxy.proxy.DataStore;
import org.ogm.crazyproxy.proxy.ProxyServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer{

	private static Logger logger = LoggerFactory.getLogger(WebConfig.class);
	
	   @Autowired
	    AutowireCapableBeanFactory beanFactory;
	   
	@Autowired
	private DataStore dataStore = null;
	
	
	   @Bean	
	   public ServletRegistrationBean<ProxyServlet> proxyServlet() {
		   
		   logger.info("xxxxdatastore" + dataStore);
		   ServletRegistrationBean<ProxyServlet> servRegBean = new ServletRegistrationBean<>();
		   ProxyServlet proxyServlet = new ProxyServlet();
		   beanFactory.autowireBean(proxyServlet);  
		   servRegBean.setServlet(proxyServlet);
		   servRegBean.addUrlMappings("/proxy/*");
		   servRegBean.setLoadOnStartup(1);
		   return servRegBean;
	   }
}
