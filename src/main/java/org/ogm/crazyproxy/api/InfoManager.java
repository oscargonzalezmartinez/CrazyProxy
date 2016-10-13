package org.ogm.crazyproxy.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.ogm.crazyproxy.api.model.Info;
import org.ogm.crazyproxy.proxy.DataStore;

@Path("/info")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InfoManager {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Info get(){
		Info info = new Info();
		info.setTarget(DataStore.getTarget());
		info.setRequest(DataStore.getRequest());
		info.setErrorThreshold(DataStore.getErrorThreshold());
		info.setExecutionTime(DataStore.getExecutionTime());
		info.setErrors(DataStore.getErrors());
		info.setDelay(DataStore.getDelay());
		return info;
	}
	
	@GET
	@Path("/target")
	public String getTarget(){
		return DataStore.getTarget();
	}
}
