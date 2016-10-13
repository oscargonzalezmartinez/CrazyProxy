package org.ogm.crazyproxy.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.ogm.crazyproxy.proxy.DataStore;

@Path("/settings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Settings {

	@POST
	@Path("/errorTH/{error}")
	public void setErrorThreshold(@PathParam("error") String errorThreshold){
		DataStore.setErrorThreshold(Integer.valueOf(errorThreshold));
	}
	
	@POST
	@Path("/delay/{delay}")
	public void setDelay(@PathParam("delay") String delay){
		DataStore.setDelay(Long.valueOf(delay));
	}
}
