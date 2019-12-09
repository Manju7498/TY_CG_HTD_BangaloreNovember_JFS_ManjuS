package linkedlist;

import java.util.LinkedList;

public class LinkedList4 {

	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.add(2);
		l.add(4);
		l.add(6);
		l.add(18);
		l.add(23);
		l.add(26);
		l.add(4);
		System.out.println("linked list elements:"+l);
		l.push(24);
		System.out.println("push : "+l);
		l.pop();
		System.out.println("pop : "+l);
		System.out.println("element : "+l.element());
	}

}
