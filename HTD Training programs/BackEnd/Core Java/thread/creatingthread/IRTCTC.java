package com.cg.thread.creatingthread;

public class IRTCTC {
	synchronized void confirmTicket() {
		for (int i = 0; i < 4; i++) {
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
		notifyAll();
	}
}
