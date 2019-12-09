import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSet1 {

	public static void main(String[] args) {
		LinkedHashSet l=new LinkedHashSet();
		l.add(12);
		l.add(18);
		l.add(16);
		l.add(null);
		Iterator itr=l.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
