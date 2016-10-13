package org.ogm.crazyproxy.proxy.workers;


public class WorkerException extends RuntimeException{
	public WorkerException(Throwable t){
		super(t);
	}
	
	public WorkerException(String message){
		super(message);
	}
}
