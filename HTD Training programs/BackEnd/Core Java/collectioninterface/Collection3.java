import java.util.ArrayList;
import java.util.Collection;

public class Collection3 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add(10);
		c.add(20);
		c.add(30);
		Collection c1=new ArrayList();
		c1.add(20);
		c1.add(50);
		c1.add(60);
		//inserting one collection into other collection
		c.addAll(c1);
		System.out.println(c);
		//removing one collection from other collection
		c.removeAll(c1);
		System.out.println(c);
		//retaining 
		System.out.println("******************");
		c.addAll(c1);
		System.out.println(c);
		System.out.println(c1);
		c.retainAll(c1);
		System.out.println(c);
		
		System.out.println("*********************");
		//checking whether collection is present
		System.out.println(c);
		System.out.println(c1);
		System.out.println(c.containsAll(c1));
		//clear 
		c1.clear();
		System.out.println(c1);
		System.out.println(c);
		System.out.println("****************");
		Collection c3=new ArrayList();
		c3.add(20);
		c3.add(50);
		c3.add(60);
		Object o[]=c3.toArray();
		for(int i=0;i<o.length;i++) {
			System.out.println(o[i]);
		}
		System.out.println("$$$$$$$$$$$$$$$$$$$");
		for(int i=0;i<c3.size();i++) {
			System.out.println(c3);
		}
		
		
		
	}

}
