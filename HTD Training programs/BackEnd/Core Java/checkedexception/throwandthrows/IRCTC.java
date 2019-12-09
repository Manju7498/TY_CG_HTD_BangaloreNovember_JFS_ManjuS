package throwandthrows;

public class IRCTC {
	void confirmBooking() throws ClassNotFoundException {
		try {
			Class c=Class.forName("nestedtry.Paytm");
			System.out.println("ticket is confirmed");
		} catch (ClassNotFoundException e) {
			System.out.println("ticket is  not confirmed");
			throw e;
		}
	}

}
