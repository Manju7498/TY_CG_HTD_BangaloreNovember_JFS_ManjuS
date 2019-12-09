
public class Calculator {
	void divide(int a,int b) {
		System.out.println("divide method called");
		try {
		System.out.println(a/b);
		}catch(ArithmeticException e) {
			System.out.println("division is not possible");
		}
		System.out.println("divided");
	}
	public static void main(String[] args) {
		System.out.println("main method started");
		Calculator c=new Calculator();
		c.divide(0, 0);
		System.out.println("main method ended");
	}

}
