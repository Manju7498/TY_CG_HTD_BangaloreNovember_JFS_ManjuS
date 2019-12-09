
import java.util.ArrayList;
import java.util.List;

public class List1 {

	public static void main(String[] args) {
		List l=new ArrayList();
		//add(index,element)
		l.add(0,10);
		l.add(1,30);
		l.add(2,40);
		System.out.println(l);
		//remove
		l.remove(1);
		System.out.println(l);
		//index(object o)
		System.out.println(l.indexOf(40));
		//lastindexof(object o)
		l.add(60);
		System.out.println(l);
		System.out.println(l.lastIndexOf(60));
		System.out.println("----------------");
		//getindex
		for(int i=0;i<l.size();i++) {
		System.out.println(l.get(i));
		}
		System.out.println("----------------");
		List l1=new ArrayList();
		l1.add(0,70);
		l1.add(1,80);
		l1.add(2,90);
		//addall
		l.addAll(l1);
		System.out.println(l);
		System.out.println("-----------------");
		//set(index,element)
		l1.set(1,75);
		System.out.println(l1);
		System.out.println("---------------");
		//sublist
		List l2=l1.subList(0, 2);
		System.out.println(l2);

	}

}
