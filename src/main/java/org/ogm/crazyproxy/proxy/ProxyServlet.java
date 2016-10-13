package org.ogm.crazyproxy.proxy;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.ogm.crazyproxy.proxy.config.Configuration;
import org.ogm.crazyproxy.proxy.workers.Worker;
import org.ogm.crazyproxy.proxy.workers.WorkerFactory;

public class ProxyServlet extends HttpServlet{

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 8335932359219477572L;


	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Configuration configuration = new Configuration();
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
        
//        URL ur = new URL("http://velazquez:18916/serviciosecuhttpchannel/bindServlet");
        WorkerFactory.newInstance().process(request.getInputStream(),  response.getOutputStream());
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	      WorkerFactory.newInstance().process(request.getInputStream(),  response.getOutputStream());

	    
	}
}
