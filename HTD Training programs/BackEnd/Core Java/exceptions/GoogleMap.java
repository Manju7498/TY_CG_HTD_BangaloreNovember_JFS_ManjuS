
public class GoogleMap {
	void findLocation(String loc) {
		try {
			System.out.println(loc.length());
		}catch(NullPointerException e) {
			System.out.println("Google user please enter location");
			throw e;
		}
	}

}
