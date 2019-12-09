package checkedexception;
public class ExceptionB {
	public static void main(String[] args) {
		System.out.println("main method started");
		Student s=new Student();
		try {
			Object s1=s.clone();
			System.out.println("object is cloned");
			Class c1=Class.forName("checkedexception.Student");
			System.out.println("class is found");
		} catch (CloneNotSupportedException e) {
			System.out.println("clone not supported");
		}catch (ClassNotFoundException e) {
			System.out.println("class not found");
		}
		System.out.println("main method ended");
	}
}
