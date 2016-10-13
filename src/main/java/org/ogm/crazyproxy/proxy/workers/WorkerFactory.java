package org.ogm.crazyproxy.proxy.workers;

import org.ogm.crazyproxy.proxy.DataStore;

public class WorkerFactory {

	public static Worker newInstance(){
		

		if (DataStore.getDelay()!=null && DataStore.getDelay() > 0){
			return new DelayerWorker(DataStore.getTarget(),DataStore.getDelay());
		}
		if (DataStore.getErrorThreshold()!=null && DataStore.getErrorThreshold() > 0){
			return new ErrorProneWorker(DataStore.getTarget(),DataStore.getErrorThreshold());
		}
		return new PassThroughWorker(DataStore.getTarget());
	}
}
