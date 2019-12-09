
public class ExceptionB {
	void exception(int a,String b) {
		try {
			System.out.println(b.length());
			try {
				System.out.println(500/a);
			}catch(ArithmeticException e) {
				System.out.println("don't deal with zero");
			}
		}catch(NullPointerException e) {
			System.out.println("don't deal with null");
		}
	}
	public static void main(String[] args) {
		System.out.println("main method started");
		ExceptionA e=new ExceptionA();
		e.exception(10,null);
		e.exception(0, "manju");
		System.out.println("main method ended");
	}

}
