
public class Person {
	private String name;
	private int age;
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return this.age;
	}
	public static void main(String[] args) {
		Person p=new Person();
		p.setAge(21);
		p.setName("Manju");
		System.out.println("Name is "+p.getName());
		System.out.println("Age is "+p.getAge());
	}

}
