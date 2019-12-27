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
		if (dataStore.getErrorThreshold()!=null || dataStore.getDelay()!=null){
			worker =  new ErrorProneWorker(dataStore.getTarget(),dataStore.getErrorThreshold(),dataStore.getDelay());
		}
		else {
			worker = new PassThroughWorker(dataStore.getTarget());
		}
		worker.setDataStore(dataStore);
		return worker;
	}
}
