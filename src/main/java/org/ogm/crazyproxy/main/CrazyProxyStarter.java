package org.ogm.crazyproxy.main;

import javax.servlet.ServletException;
import javax.websocket.DeploymentException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;
import org.ogm.crazyproxy.api.ws.StatsSocket;
import org.ogm.crazyproxy.proxy.DataStore;
import org.ogm.crazyproxy.proxy.config.Configuration;


public class CrazyProxyStarter {

    public static void main(String[] args) throws Exception{

    	new Configuration();
    	
        final Server server = new Server(DataStore.getPort());
        final WebAppContext root = new WebAppContext();

        root.setContextPath("/");
        // Parent loader priority is a class loader setting that Jetty accepts.
        // By default Jetty will behave like most web containers in that it will
        // allow your application to replace non-server libraries that are part of the
        // container. Setting parent loader priority to true changes this behavior.
        // Read more here: http://wiki.eclipse.org/Jetty/Reference/Jetty_Classloading
        root.setParentLoaderPriority(true);

        //if ("dev".equals(DataStore.getMode())){
        	final String webappDirLocation = "target/classes/webapp/";
        	root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        	root.setResourceBase(webappDirLocation);
        //}
        //else{
        //	root.setWar("./webapps/crazy-proxy.war");
        //}
        
            ServletContextHandler wsHandler = newWSHandler(server);
            
            ContextHandlerCollection handlers = new ContextHandlerCollection();
            handlers.addHandler(wsHandler);
            handlers.addHandler(root);
            
        server.setHandler(handlers);

        WebSocketServerContainerInitializer.configureContext(wsHandler).addEndpoint(StatsSocket.class);
        
        server.start();
        server.join();
    }
    
    public static ServletContextHandler newWSHandler(Server server) throws ServletException, DeploymentException{
    	
    	ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    	context.setContextPath("/events");
   	    return context;

    }
}
