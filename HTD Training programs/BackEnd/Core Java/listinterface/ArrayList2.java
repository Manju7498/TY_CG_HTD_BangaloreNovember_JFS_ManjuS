import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList2 {

	public static void main(String[] args) {
		ArrayList<String> a=new ArrayList<String>();
		a.add("manju");
		a.add("syamala");
		a.add("gayathri");
		a.add("pranitha");
		System.out.println(a);
		a.remove(1);
		a.remove(new String("gayathri"));
		System.out.println(a);
		System.out.println(a.size());
		System.out.println(a.isEmpty());
		System.out.println(a.contains("manju"));
		ArrayList<String> a1=new ArrayList<String>();
		a1.add("manju");
		a1.add("chinni");
		a1.add("ammu");
		a1.add("bhargavi");
		System.out.println(a1);
		a.addAll(1, a1);
		System.out.println(a);
		a.removeAll(a1);
		System.out.println(a1);
		System.out.println(a.containsAll(a1));
		System.out.println(a);
		System.out.println(a1);
		a.retainAll(a1);
		System.out.println(a);
		a1.clear();
		ArrayList<String> a3=new ArrayList<String>();
		a3.add("manju");
		a3.add("syamala");
		a3.add("gayathri");
		a3.add("pranitha");
		System.out.println(a3);
		ArrayList<String> a4=new ArrayList<String>();
		a4.add("manju");
		a4.add("chinni");
		a4.add("ammu");
		a4.add("bhargavi");
		System.out.println(a4);
		a4.add(1,"goud");
		System.out.println(a4);
		System.out.println(a4.indexOf("manju"));
		System.out.println(a4.lastIndexOf("bhargavi"));
		/*System.out.println("*********for loop***********");
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i));
		}
		System.out.println("****for each****");
		for(String i1:a) {
			System.out.println(i1);
		}
		System.out.println("****iterator******");
		Iterator<String> i3=a.iterator(); 
		while(i3.hasNext()) {
			System.out.println(i3.next());
		}
		System.out.println("*********listiterator**********");
		ListIterator<String> i4=a.listIterator(); 
		while(i4.hasNext()) {
			System.out.println(i4.next());
		}
		while(i4.hasPrevious()) {
			System.out.println(i4.previous());
		}*/
	}

}
