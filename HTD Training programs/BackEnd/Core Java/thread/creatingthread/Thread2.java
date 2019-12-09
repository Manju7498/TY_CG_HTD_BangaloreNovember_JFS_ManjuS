package com.cg.thread.creatingthread;

public class Thread2 implements Runnable {
	@Override
	public void run() {
		for(int i=1;i<=3;i++) {
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		System.out.println("main started");
		Thread2 t2=new Thread2();
		Thread t=new Thread(t2);
		t.start();
		System.out.println("main ended");
	}
	

}
