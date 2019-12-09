package customchecked;

public class Person {
	public static void main(String[] args) {
		System.out.println("main method started");
		Election e=new Election();
		try {
			e.vote(21);
		} catch (AgeLimitException e1) {
			System.out.println(e1.msg);
		}
		System.out.println("main method ended");
	}

}
