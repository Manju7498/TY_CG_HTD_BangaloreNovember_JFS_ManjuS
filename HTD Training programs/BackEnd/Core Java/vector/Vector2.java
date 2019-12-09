import java.util.Vector;

public class Vector2 {

	public static void main(String[] args) {
		Vector v=new Vector();
		System.out.println("initial size : "+v.size());
		System.out.println("intial capacity : "+v.capacity());
		v.add(2);
		v.add(4);
		v.add(6);
		v.add(8);
		v.add(10);
		v.add(12);
		v.add(14);
		v.add(16);
		v.add(18);
		v.add(20);
		v.add(22);
		System.out.println("elements : "+v);
		System.out.println("size : "+v.size());
		System.out.println("capacity : "+v.capacity());
		v.trimToSize();
		System.out.println("trimtosize : "+v.size());
		v.setSize(10);
		System.out.println("setsize : "+v.size());
		v.add(18);
		System.out.println("add element : "+v);
		v.set(8, 7);
		System.out.println("add ele with index : "+v);
		System.out.println("*************************************************");
		Vector v1=new Vector();
		v1.add(2);
		v1.add(4);
		System.out.println("initial size : "+v1.size());
		System.out.println("intial capacity : "+v1.capacity());
		v1.trimToSize();
		System.out.println("size : "+v1.size());
		System.out.println("capacity : "+v1.capacity());
		v1.ensureCapacity(6);
		v1.setSize(8);
		System.out.println("size after ensure capacity() : "+v1.size());
		System.out.println("capacity after ensure capacity() : "+v1.capacity());
	}

}
