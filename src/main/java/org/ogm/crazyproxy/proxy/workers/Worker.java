package org.ogm.crazyproxy.proxy.workers;

import java.io.InputStream;
import java.io.OutputStream;

public interface Worker {

	public void pre(InputStream ism, OutputStream osm);
	public void process(InputStream ism, OutputStream osm);
	public void post(InputStream ism, OutputStream osm);
	public long getExecutionTime();
}
