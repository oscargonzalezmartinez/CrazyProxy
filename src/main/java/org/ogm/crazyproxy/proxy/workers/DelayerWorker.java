package org.ogm.crazyproxy.proxy.workers;

import java.io.InputStream;
import java.io.OutputStream;

public class DelayerWorker extends PassThroughWorker{

	private Long delay = null;

	public DelayerWorker(String newTarget) {
		super(newTarget);
	}

	public DelayerWorker(String newTarget, Long delay) {
		this(newTarget);
		this.delay = delay;
	}

	@Override
	public void doProcess(InputStream ism, OutputStream osm) {
		try {
			Thread.currentThread().sleep(delay);
		} catch (InterruptedException e) {
			throw new WorkerException(e);
		}
		super.doProcess(ism, osm);

	}

	
}
