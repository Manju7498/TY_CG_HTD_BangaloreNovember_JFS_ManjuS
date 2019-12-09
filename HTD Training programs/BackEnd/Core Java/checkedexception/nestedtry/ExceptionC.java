package nestedtry;

public class ExceptionC {
	public static void main(String[] args) {
		System.out.println("main method started");
		Employee e=new Employee();
		try {
			Object e1=e.clone();
			System.out.println("clone is supported");
			try {
				Class c=Class.forName("nestedtry.Employee");
				System.out.println("class is found");
			} catch (ClassNotFoundException e2) {
				System.out.println("class not found");
			}
		} catch (CloneNotSupportedException e1) {
			System.out.println("clone not supported");
		}
		System.out.println("main method ended");
	}

}
