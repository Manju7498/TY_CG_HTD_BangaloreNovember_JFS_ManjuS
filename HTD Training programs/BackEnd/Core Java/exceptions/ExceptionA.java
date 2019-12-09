
public class ExceptionA {
	void exception(int a,String b) {
		try {
		System.out.println(500/a);
		System.out.println(b.length());
		}catch(ArithmeticException e) {
			System.out.println("don't deal with zero");
		}catch(NullPointerException e) {
			System.out.println("don't deal with null");
		}
	}
	public static void main(String[] args) {
		System.out.println("main method started");
		ExceptionA e=new ExceptionA();
		e.exception(0, "manju");
		e.exception(10, null);
		System.out.println("main method ended");
	}

}
