package com.cg.thread.creatingthread;

public class Thread1 extends Thread{
	public void run() {
		for(int i=0;i<=3;i++) {
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		System.out.println("main started");
		Thread1 t=new Thread1();
		t.start();
		System.out.println("main ended");
	}
}
