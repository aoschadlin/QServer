package com.kyeema.QServer;

import java.util.Queue;
import java.util.LinkedList;

public class BaseQueue {
	protected BaseQueue() {
        qe = new LinkedList<String>();
	}
	
	public static BaseQueue getInstance() {
		if (instance == null) {
			instance = new BaseQueue();
		}
		return instance;
	}
	
	public void addElement(String newElement) {
		synchronized (lock) {
			qe.add(newElement);
		}
	}
	
	public int size() {
		synchronized (lock) {
			return qe.size();
		}
	}

	public String getElement() {
		synchronized (lock) {
			return qe.poll();
		}
	}

	private Queue<String> qe;
	static private BaseQueue instance = null;
	static private LockObject lock = new LockObject();}
