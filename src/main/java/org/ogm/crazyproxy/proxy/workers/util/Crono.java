package org.ogm.crazyproxy.proxy.workers.util;

public class Crono {

	private long time = System.currentTimeMillis();
	public void reset(){
		time = System.currentTimeMillis();
	}
	
	public long getStartTime(){
		return time;
	}
	
	public long getElapsedTime(){
		return  System.currentTimeMillis() - time;
	}
}
