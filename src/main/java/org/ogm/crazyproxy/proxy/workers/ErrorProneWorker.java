package org.ogm.crazyproxy.proxy.workers;

import java.io.InputStream;
import java.io.OutputStream;

public class ErrorProneWorker extends PassThroughWorker{

	private Integer errorThreshold = null;

	public ErrorProneWorker(String newTarget) {
		super(newTarget);
	}

	public ErrorProneWorker(String newTarget, Integer errorThreshold) {
		this(newTarget);
		this.errorThreshold = errorThreshold;
	}

	@Override
	public void doProcess(InputStream ism, OutputStream osm) {
		//cuanto más alto TH más fácilmente fallamos.
		if (errorThreshold > Math.round((Math.random() * 100))){
			throw new WorkerException("KASKE !!!");
		}
		else{
			super.doProcess(ism, osm);
		}
	}

	
}
