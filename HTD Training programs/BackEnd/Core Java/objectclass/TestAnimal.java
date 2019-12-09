
public class TestAnimal {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Dog d=new Dog("pinky");
		Class c=d.getClass();
		System.out.println(c);
		Dog d1=(Dog)c.newInstance();
		System.out.println(d1.name);
		Class c2=c.forName("Pen");
		System.out.println(c2);
	}

}
