package com.kyeema.QServer;

import com.kyeema.QServer.QServerApplication;
import org.restlet.Component;
import org.restlet.data.Protocol;

public class App 
{
	public static void main(String[] args) {
		System.out.println("Starting server");

		try {
			// Create a new Component.  
		    Component component = new Component();  
		  
		    // Add a new HTTP server listening on port 4080.  
		    component.getServers().add(Protocol.HTTP, 4080);  
		  
		    // Attach the sample application.  
		    component.getDefaultHost().attach("/main", new QServerApplication());  
		  
			// Start the component.  
		    component.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
