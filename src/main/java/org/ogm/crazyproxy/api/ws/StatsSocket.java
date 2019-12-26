package org.ogm.crazyproxy.api.ws;

import javax.websocket.ClientEndpoint;

import org.ogm.crazyproxy.api.InfoManager;
import org.ogm.crazyproxy.api.model.Info;
import org.ogm.crazyproxy.proxy.DataStore;
import org.ogm.crazyproxy.proxy.DataStoreChangeListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@ClientEndpoint
public class StatsSocket implements DataStoreChangeListener{

	@Autowired
	private InfoManager infoManager = null;
	
	public StatsSocket(@Autowired DataStore dataStore) {
		dataStore.addListener(this);		
	}
	
	@MessageMapping("/stats")
	@SendTo("/topic/stats")
	public Info sendStats() {
		return infoManager.get();
	}
	
	public void onChange() {
		sendStats();
		
	}
}
