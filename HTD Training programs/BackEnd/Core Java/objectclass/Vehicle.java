
public class Vehicle implements Cloneable {
	String name;

	public Vehicle(String name) {
		super();
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	 public static void main(String[] args) throws CloneNotSupportedException {
		Vehicle v=new Vehicle("verna");
		Object o=v.clone();
		Vehicle v1=(Vehicle)o;
		System.out.println(v.name);
		System.out.println(v);
		System.out.println(v1);
		System.out.println(o);
		System.out.println(v1.name);
		
	}

}
