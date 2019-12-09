import java.util.ArrayList;
import java.util.Collection;

public class Collection1 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		//inserting element into an collection
		c.add(18);
		System.out.println(c);
		//deleting an element from collection
		c.remove(18);
		System.out.println(c);
		//size of collection
		System.out.println(c.size());
		//check whether collection is empty r not
		System.out.println(c.isEmpty());
		//checking whether object is there r not
		System.out.println(c.contains(12));
		
		
		
	}

}
