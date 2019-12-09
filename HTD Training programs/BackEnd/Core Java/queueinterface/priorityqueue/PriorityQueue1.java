package com.cg.queue.priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue1 {

	public static void main(String[] args) {
		Queue p=new PriorityQueue();
		p.offer(72);
		p.offer(65);
		p.offer(89);
		p.offer(3);
		p.offer(6);
		System.out.println("elements : "+p);
		p.poll();
		p.poll();
		System.out.println("elements after poll : "+p);
		System.out.println("peek() : "+p.peek());
		p.remove(89);
		System.out.println("elements after remove() : "+p);
		System.out.println("element() : "+p.element());
		for (Object ob : p) {
			System.out.println(ob);
		}
	}

}
