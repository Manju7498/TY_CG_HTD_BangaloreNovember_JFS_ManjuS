package com.cg.queue.arraydequeue;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeue1 {
	public static void main(String[] args) {
		/*ArrayDeque a=new ArrayDeque();
		a.add(23);
		a.add(76);
		a.add(45);
		a.add(54);
		Iterator itr = a.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}*/
		ArrayDeque<String> a1=new ArrayDeque<String>();
		a1.add("manju");
		a1.add("pranitha");
		a1.add("pooja");
		a1.add("gayathri");
		Iterator<String> itr1 = a1.iterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}
		a1.addFirst("syamala");
		System.out.println("add first : "+a1);
		a1.addLast("lakshmi");
		System.out.println("add last : "+a1);
		System.out.println("get first : "+a1.getFirst());
		System.out.println("get last : "+a1.getLast());
		a1.remove();
		System.out.println("remove() : "+a1);
		System.out.println("remove first : "+a1.removeFirst());
		System.out.println("remove last : "+a1.removeLast());
		a1.add("pranitha");
		a1.add("pooja");
		a1.removeFirstOccurrence("pranitha");
		System.out.println("remove first occurance : "+a1);
		a1.removeLastOccurrence("pooja");
		System.out.println("remove last occurance : "+a1);
		System.out.println("peek : "+a1.peek());
		System.out.println("peek first : "+a1.peekFirst());
		System.out.println("peek last : "+a1.peekLast());
		a1.poll();
		System.out.println("poll : "+a1);
		
	}

}
