package com.cg.thread.creatingthread;

public class User extends Thread {
	PVR p;
	User(PVR p) {
		this.p=p;
	}
	public void run() {
		p.confirmTickects();
	}
	public static void main(String[] args) {
		System.out.println("main started");
		PVR p=new PVR();
		User u=new User(p);
		u.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		p.leave();
		System.out.println("main ended");
	}
}
