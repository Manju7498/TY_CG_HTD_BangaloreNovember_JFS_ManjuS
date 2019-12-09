
public class ClassA {
	static void o () {
		try {
		System.out.println(10/0);
		}catch(ArithmeticException e) {
			System.out.println("class A "+e.getMessage());
		}
	}

}
