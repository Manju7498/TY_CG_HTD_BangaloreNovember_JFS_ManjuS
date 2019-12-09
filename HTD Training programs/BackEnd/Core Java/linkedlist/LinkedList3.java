package linkedlist;
import java.util.LinkedList;
public class LinkedList3 {
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
		System.out.println("peek: "+l.peek());
		System.out.println("peekfirst :"+l.peekFirst());
		System.out.println("peeklast :"+l.peekLast());
		System.out.println("poll: "+l.poll());
		System.out.println("pollfirst :"+l.pollFirst());
		System.out.println("polllast :"+l.pollLast());
		l.offer(1);
		System.out.println("offer: "+l);
		l.offerFirst(3);
		System.out.println("offerfirst :"+l);
		l.offerLast(11);
		System.out.println("offerlast :"+l);

	}

}
