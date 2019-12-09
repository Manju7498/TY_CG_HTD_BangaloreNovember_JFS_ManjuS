
public class Person {
	String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize method");
		super.finalize();
		
		
	}
	public static void main(String[] args) throws Throwable {
		System.out.println("**main start**");
		Person p=new Person("manju");
		p.finalize();
		p=null;
		System.gc();
		System.out.println("***main end****");
	}

}
