package org.ogm.crazyproxy.api;

import org.ogm.crazyproxy.api.model.Info;
import org.ogm.crazyproxy.proxy.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/info")
public class InfoManager {

	@Autowired
	private DataStore dataStore = null;
	
	@GetMapping
	@RequestMapping("/get")
	public Info get(){
		Info info = new Info();
		info.setTarget(dataStore.getTarget());
		info.setRequest(dataStore.getRequest());
		info.setErrorThreshold(dataStore.getErrorThreshold());
		info.setExecutionTime(dataStore.getExecutionTime());
		info.setErrors(dataStore.getErrors());
		info.setDelay(dataStore.getDelay());
		return info;
	}
	
	@GetMapping
	@RequestMapping("/target")
	public String getTarget(){
		return dataStore.getTarget();
	}
}
