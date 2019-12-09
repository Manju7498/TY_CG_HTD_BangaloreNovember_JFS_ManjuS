package throwandthrows;

public class Paytm {
	IRCTC i;

	public Paytm(IRCTC i) {
		super();
		this.i = i;
	}
	void bookTicket() {
		try {
			i.confirmBooking();
			System.out.println("ticket is booked");
		} catch (ClassNotFoundException e) {
			System.out.println("ticket is not booked");
		}
	}

}
