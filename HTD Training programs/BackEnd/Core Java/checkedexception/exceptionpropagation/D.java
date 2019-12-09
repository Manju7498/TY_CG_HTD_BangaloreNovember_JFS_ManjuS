package exceptionpropagation;

public class D {
	static void o() throws ClassNotFoundException {
		Class c=Class.forName("A");
	}

}
