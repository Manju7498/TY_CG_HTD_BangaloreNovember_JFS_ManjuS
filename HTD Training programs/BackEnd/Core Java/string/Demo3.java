
public class Demo3 {
	private String name;
	private int age;
	public Demo3(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	String getName() {
		return name;
	}
	int getAge() {
		return age;
	}
	public static void main(String[] args) {
		Demo3 d=new Demo3("manju",21);
		System.out.println(d.hashCode());
		System.out.println("name is "+d.getName()+" age is "+d.getAge());
		d=new Demo3("gayathri",22);
		System.out.println(d.hashCode());
		System.out.println("name is "+d.getName()+" age is "+d.getAge());
	}
}
