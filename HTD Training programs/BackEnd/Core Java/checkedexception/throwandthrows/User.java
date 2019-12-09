package throwandthrows;

public class User {
	public static void main(String[] args) {
		System.out.println("main started");
		IRCTC i=new IRCTC();
		Paytm p=new Paytm(i);
		p.bookTicket();
		System.out.println("main ended");
		
	}

}
