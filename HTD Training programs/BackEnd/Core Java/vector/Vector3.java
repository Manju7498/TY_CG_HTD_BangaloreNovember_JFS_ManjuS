import java.util.Vector;

public class Vector3 {

	public static void main(String[] args) {
		Vector v=new Vector();
		v.addElement(100);
		v.addElement(200);
		v.addElement(300);
		v.addElement(400);
		v.add(500);
		System.out.println("elements : "+v);
		v.removeElement(400);
		System.out.println("element removed : "+v);
		v.removeElementAt(2);
		System.out.println("element removed at index : "+v);
		System.out.println("********for loop*************");
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
		Integer []a=new Integer[v.size()];
		v.copyInto(a);
		System.out.println("*********array iterator*********** ");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		v.removeAllElements();
		System.out.println("remove all elements : "+v);
		
	}

}
