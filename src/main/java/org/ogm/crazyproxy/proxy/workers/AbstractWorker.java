package org.ogm.crazyproxy.proxy.workers;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.ogm.crazyproxy.proxy.DataStore;
import org.ogm.crazyproxy.proxy.workers.util.Crono;

public abstract class AbstractWorker  implements Worker{

	protected URL targetUrl = null;
	protected String target = null;
	protected Crono crono = new Crono();
	protected long executionTime = 0;

	public AbstractWorker(String newTarget) {
		super();
		target = newTarget;
		try {
			targetUrl = new URL(target);
		} catch (MalformedURLException e) {
			throw new WorkerException(e);
		}
	}
	
	public long getExecutionTime() {
		return executionTime;
	}
	
	public void pre(InputStream ism, OutputStream osm) {
		crono.reset();
	}
	
	public void process(InputStream ism, OutputStream osm){
		DataStore.addRequest();
		pre(ism, osm);
		try{
			doProcess(ism, osm);
		}catch(WorkerException e){
			DataStore.addError();
			throw e;
		}finally{
			post(ism, osm);
			DataStore.addExecutionTime(executionTime);
		}
	}
	
	public abstract void doProcess(InputStream ism, OutputStream osm);
	
	public void post(InputStream ism, OutputStream osm) {
		executionTime = crono.getElapsedTime();
	}		
}
