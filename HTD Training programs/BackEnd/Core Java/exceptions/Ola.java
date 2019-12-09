
public class Ola {
	GoogleMap g1;
	
	public Ola(GoogleMap g1) {
		super();
		this.g1 = g1;
	}
	void find(String a) {
		try {
			g1.findLocation(a);
		}catch(NullPointerException e) {
			System.out.println("Ola user please enter location");
		}
	}
	public static void main(String[] args) {
		System.out.println("main method started");
		GoogleMap g1=new GoogleMap();
		Ola o=new Ola(g1);
		o.find(null);
		System.out.println("main method ended");
	}

}
