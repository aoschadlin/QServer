package com.kyeema.QServer;

import java.util.Date;

public class Consumer extends Thread {
	public Consumer() {
		//
	}
	
	public void run() {
		boolean qProcessing = false;
		BaseQueue q = BaseQueue.getInstance();
		while (true) {
			try {
				if (q.size() > 0) {
					if (qProcessing == false) {
						qProcessing = true;
						startTime = new Date();
					}
					// Do something with the element (maybe send it to the backend server?)
					q.getElement();
					Thread.sleep(25);
				} else {
					if (qProcessing == true) {					
						qProcessing = false;
						endTime = new Date();
						long delta = endTime.getTime() - startTime.getTime();
						System.out.printf("Queue is empty in %d ms", delta);
					}
					Thread.sleep(10);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Date startTime;
	private Date endTime;
}
