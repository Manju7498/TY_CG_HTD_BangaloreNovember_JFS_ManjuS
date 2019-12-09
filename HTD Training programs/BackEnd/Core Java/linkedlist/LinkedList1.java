package linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedList1 {
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.add(2);
		l.add(4);
		l.add(23);
		l.add(18);
		l.add(null);
		ListIterator ltr=l.listIterator();
		while(ltr.hasNext()) {
			System.out.println(ltr.next());
		}
		l.add(4);
		System.out.println(l);
		l.remove(new Integer(4));
		System.out.println(l);
		System.out.println("******for each**********");
		for (Object i2 : l) {
			System.out.println(i2);
		}
		System.out.println("***********for loop***********");
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
	}

}
