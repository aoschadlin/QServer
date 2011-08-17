package com.kyeema.QServer;

public class Producer extends Thread {
	public Producer() {
		q = BaseQueue.getInstance();
	}
	
	public void run() {
		for (int i=0; i < 1000; i++) {
			q.addElement("Item" + i);
		}
	}

	private BaseQueue q;
}
