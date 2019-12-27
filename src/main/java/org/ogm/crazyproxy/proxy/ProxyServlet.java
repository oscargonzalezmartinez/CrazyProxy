package org.ogm.crazyproxy.proxy;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ogm.crazyproxy.proxy.workers.WorkerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProxyServlet  extends HttpServlet{

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 8335932359219477572L;

	private static Logger logger = LoggerFactory.getLogger(ProxyServlet.class);
	
	@Autowired 
	private WorkerFactory workerFactory = null;


	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        workerFactory.newInstance().process(request.getInputStream(),  response.getOutputStream());
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	      workerFactory.newInstance().process(request.getInputStream(),  response.getOutputStream());

	    
	}
}
