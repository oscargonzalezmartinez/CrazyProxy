package org.ogm.crazyproxy.proxy.workers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

public class PassThroughWorker extends AbstractWorker{

	public PassThroughWorker(String newTarget) {
		super(newTarget);
	}

	public void doProcess(InputStream ism, OutputStream osm){
        try{
        	if (logger.isInfoEnabled()) {
        		logger.info("Open connection against " + targetUrl);
        	}
	        URLConnection conn = targetUrl.openConnection();
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        conn.connect();
	        
	        IOUtils.copy(ism,  conn.getOutputStream());
	        IOUtils.copy(conn.getInputStream(),  osm);
	        
		} catch (MalformedURLException e) {
			throw new WorkerException(e);
		} catch (IOException e) {
			throw new WorkerException(e);		
		}
	}
}
