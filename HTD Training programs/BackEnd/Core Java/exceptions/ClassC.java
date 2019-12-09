
public class ClassC {
	 static void f() {
		 try {
		ClassB.m();
		 }catch(ArithmeticException e) {
			 throw e;
		 }
	}

}
