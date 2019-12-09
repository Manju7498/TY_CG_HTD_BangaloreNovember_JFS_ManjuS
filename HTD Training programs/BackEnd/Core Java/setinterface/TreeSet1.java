import java.util.TreeSet;

public class TreeSet1 {

	public static void main(String[] args) {
		TreeSet t=new TreeSet();
		t.add(21);
		t.add(18);
		t.add(16);
		t.add(6);
		t.add(16);
		t.remove(16);
		for (Object o : t) {
			System.out.println(o);
		}
	}

}
