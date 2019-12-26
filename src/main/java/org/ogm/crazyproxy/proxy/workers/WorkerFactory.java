package org.ogm.crazyproxy.proxy.workers;

import org.ogm.crazyproxy.proxy.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkerFactory {

	@Autowired
	private DataStore dataStore = null;
	
	public Worker newInstance(){
		
		Worker worker = null;
		if (dataStore.getDelay()!=null && dataStore.getDelay() > 0){
			worker =  new DelayerWorker(dataStore.getTarget(),dataStore.getDelay());
		}
		if (dataStore.getErrorThreshold()!=null && dataStore.getErrorThreshold() > 0){
			worker =  new ErrorProneWorker(dataStore.getTarget(),dataStore.getErrorThreshold());
		}
		else {
			worker = new PassThroughWorker(dataStore.getTarget());
		}
		worker.setDataStore(dataStore);
		return worker;
	}
}
