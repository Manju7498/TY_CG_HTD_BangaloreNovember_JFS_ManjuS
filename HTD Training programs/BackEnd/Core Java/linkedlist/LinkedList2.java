package linkedlist;

import java.util.LinkedList;

public class LinkedList2 {

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.add(2);
		l.add(4);
		l.add(23);
		l.add(18);
		l.add(23);
		l.add(26);
		l.add(4);
		System.out.println("add(): "+l);
		l.addFirst(16);
		System.out.println("addfirst(): "+l);
		l.addLast(24);
		System.out.println("addlast(): "+l);
		l.remove();
		System.out.println("remove(): "+l);
		l.removeFirst();
		System.out.println("removefirst(): "+l);
		l.removeLast();
		System.out.println("removelast(): "+l);
		l.removeFirstOccurrence(23);
		System.out.println("removefirstoccurance(): "+l);
		l.removeLastOccurrence(4);
		System.out.println("removelastoccurance(): "+l);
		System.out.println("getfirst(): "+l.getFirst());
		System.out.println("getlast(): "+l.getLast());
		
	}

}
