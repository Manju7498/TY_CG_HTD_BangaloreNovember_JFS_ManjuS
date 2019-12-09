import java.util.ArrayList;
import java.util.Collection;

public class Collection2 {

	public static void main(String[] args) {
		Collection c=new ArrayList();
		//inserting element into an collection
		c.add("manju");
		c.add("syamala");
		System.out.println(c);
		//deleting an element from collection
		c.remove("manju");
		System.out.println(c);
		//size of collection
		System.out.println(c.size());
		//check whether collection is empty r not
		System.out.println(c.isEmpty());
		//checking whether object is there r not
		System.out.println(c.contains("syamala"));
		
	}

}
