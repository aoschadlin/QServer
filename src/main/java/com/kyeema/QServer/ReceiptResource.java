package com.kyeema.QServer;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class ReceiptResource extends ServerResource {
	
	@Post
	public void acceptJsonRepresentation(JsonRepresentation jsonStr) {
		JSONObject json = null;
		
		// Do some storage
		try {
			if (jsonStr == null) {
				System.out.println("JSON string is null");
			} else {
				json = jsonStr.getJsonObject();
			}
		} catch (Exception e) {
			System.out.println("Unable to process jsonStr " + e.toString());
		}
		
		try {
			if (json != null) {
				// System.out.println("Storing json *" + json.toString() + "*");
				BaseQueue.getInstance().addElement(json.toString());
				// WorkerThread wt = ThreadPool.getInstance().getNextThread();
				// wt.setText(json.toString());
				// wt.start();
			}
		} catch (Exception e) {
			System.out.println("Unable to store json object" + e.toString());
		}
	}
	
	@Get
	public String toString() {
		return "ping...me...";
	}
}
