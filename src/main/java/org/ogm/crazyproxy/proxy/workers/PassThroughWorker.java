package org.ogm.crazyproxy.proxy.workers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.apache.commons.io.IOUtils;

public class PassThroughWorker extends AbstractWorker{

	public PassThroughWorker(String newTarget) {
		super(newTarget);
	}

	public void doProcess(InputStream ism, OutputStream osm){
		HttpURLConnection httpUrl = null;

       	if (logger.isInfoEnabled()) {
       		logger.info("Open connection against " + targetUrl);
       	}

        try {
        	
        	httpUrl = (HttpURLConnection)targetUrl.openConnection();
        
        	httpUrl.setDoOutput(true);
        	httpUrl.setDoInput(true);
        	httpUrl.connect();
	        
	        IOUtils.copy(ism,  httpUrl.getOutputStream());
	        //invocamos a responseCode para que actualice errorStream en caso de error
	        httpUrl.getResponseCode();
	        InputStream stream = httpUrl.getErrorStream();
	        if (stream != null) {
	        	dataStore.addError();
	        }else {
	            stream = httpUrl.getInputStream();
	        }
	        IOUtils.copy(stream,  osm);
	        
		} catch (MalformedURLException e) {
			throw new WorkerException(e);
		} catch (IOException e) {
			throw new WorkerException(e);		
		}finally {
			httpUrl.disconnect();
		}
	}
}
