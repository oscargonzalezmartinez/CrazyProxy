package org.ogm.crazyproxy.api.ws;

import org.ogm.crazyproxy.api.InfoManager;
import org.ogm.crazyproxy.proxy.DataStore;
import org.ogm.crazyproxy.proxy.DataStoreChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StatsSocket implements DataStoreChangeListener{
	
	@Autowired
	private InfoManager infoManager = null;
	
    @Autowired
    private SimpMessagingTemplate broker = null;
	
	public StatsSocket(@Autowired DataStore dataStore) {
		dataStore.addListener(this);		
	}
	
	public void onChange() {
		if (log.isDebugEnabled()) {
			log.debug("onChange");
		}

		
		 broker.convertAndSend("/topic/stats", infoManager.get());
	}
}
