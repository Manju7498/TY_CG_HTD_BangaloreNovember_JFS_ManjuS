package com.cg.thread.creatingthread;

public class User1 extends Thread {
	IRTCTC i;
	User1(IRTCTC i) {
		this.i=i;
	}
	public void run() {
		i.confirmTicket();
	}
	public static void main(String[] args) {
		System.out.println("main started");
		IRTCTC i=new IRTCTC();
		User1 u=new User1(i);
		User1 u1=new User1(i);
		u.start();
		u1.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		i.leave();
		System.out.println("ID : "+u.getId());
		System.out.println("main ended");
	}
}
