package org.ogm.crazyproxy.api.ws;

import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.ogm.crazyproxy.api.InfoManager;
import org.ogm.crazyproxy.api.model.Info;
import org.ogm.crazyproxy.proxy.DataStore;
import org.ogm.crazyproxy.proxy.DataStoreChangeListener;

@ServerEndpoint(value = "/stats")
@ClientEndpoint
public class StatsSocket implements DataStoreChangeListener{
	private Session _session = null;
	
	public StatsSocket() {
		DataStore.addListener(this);		
	}
	
	@OnMessage
    public void onMessage(String txt, Session session) throws IOException {
        System.out.println("Message received: " + txt);
        String jsonString = getInfoJSON();

        session.getAsyncRemote().sendText(jsonString);
    }


	
	@OnOpen

		public void onSessionOpened(Session session){
		//DataStore.addListener(this);
		_session = session;
		}
	
	@OnClose
		public void onClose(Session session, CloseReason closeReason){

		}
	
	@OnError
		public void onErrorReceived(Throwable t) {

		}
	
	private String getInfoJSON() {
		Info info = new InfoManager().get();
        JsonObjectBuilder builder = Json.createObjectBuilder();
        if (info.getDelay()!=null)
        	builder.add("delay", info.getDelay());
 
        if (info.getTarget()!=null)
        	builder.add("target", info.getTarget());
        
        if (info.getRequest()!=null)
        	builder.add("request", info.getRequest());
        
        if (info.getErrorThreshold()!=null)
        	builder.add("errorThreshold", info.getErrorThreshold());
        
        if (info.getErrors()!=null)
        	builder.add("errors", info.getErrors());
        
        if (info.getExecutionTime()!=null)
        	builder.add("executionTime", info.getExecutionTime());

        return builder.build().toString();

	}



	public void onChange() {
		_session.getAsyncRemote().sendText(getInfoJSON());
		
	}
}
