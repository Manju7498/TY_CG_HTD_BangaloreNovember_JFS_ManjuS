import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList1 {

	public static void main(String[] args) {
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(12);
		a.add(14);
		a.add(16);
		System.out.println(a);
		System.out.println("*********for loop***********");
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i));
		}
		System.out.println("****for each****");
		for(Integer i1:a) {
			System.out.println(i1);
		}
		System.out.println("****iterator******");
		Iterator<Integer> i3=a.iterator(); 
			while(i3.hasNext()) {
				System.out.println(i3.next());
			}
			System.out.println("*********listiterator**********");
			ListIterator<Integer> i4=a.listIterator(a.size()); 
				while(i4.hasPrevious()) {
					System.out.println(i4.previous());
				}
		



	}

}
