
public class FinalTest {
	public static void main(String[] args) {
		System.out.println("main method started");
		try {
			System.out.println(20/ 0);
		}catch(ArithmeticException e) {
			System.out.println("dont deal with zero");
		}finally {
			System.out.println("finally block");
		}
		System.out.println("main method ended");
	}

}
