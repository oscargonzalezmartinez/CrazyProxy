package org.ogm.crazyproxy.api;


import org.ogm.crazyproxy.proxy.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping(path = "/settings")
public class Settings {

	@Autowired
	private DataStore dataStore = null;
	@PostMapping
	@RequestMapping("/errorTH/{errorThreshold}")
	public void setErrorThreshold(@PathVariable String errorThreshold){
		dataStore.setErrorThreshold(Long.valueOf(errorThreshold));
	}
	
	@PostMapping
	@RequestMapping("/delay/{delay}")

	public void setDelay(@PathVariable String delay){
		dataStore.setDelay(Long.valueOf(delay));
	}
}
