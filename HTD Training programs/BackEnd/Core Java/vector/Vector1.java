import java.util.Vector;

public class Vector1 {

	public static void main(String[] args) {
		Vector v=new Vector();
		v.add(2);
		v.add(4);
		v.add(6);
		v.add(8);
		v.add(10);
		System.out.println("elements : "+v);
		v.remove(new Integer(6));
		System.out.println("remove : "+v);
		v.set(1,3);
		System.out.println("set : "+v);
		System.out.println("for loop : ");
		for (int i = 0; i < v.size(); i++) {
			System.out.print("     "+v.get(i)+" ");
		}
	}

}
