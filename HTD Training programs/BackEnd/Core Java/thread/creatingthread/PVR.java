package com.cg.thread.creatingthread;

public class PVR {
	synchronized void confirmTickects() {
		for(int i=1;i<=3;i++) {
			System.out.println(i);
			/*try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	synchronized void leave() {
		System.out.println("notify called");
		notify();
	}
}