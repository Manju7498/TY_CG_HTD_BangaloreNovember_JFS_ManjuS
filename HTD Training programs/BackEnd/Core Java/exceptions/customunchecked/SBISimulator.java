package customunchecked;

public class SBISimulator {
	void withdrawal(double amount) {
		if(amount>40000) {
			throw new DayLimitException("day limit Exceeded");
		}
	}
	public static void main(String[] args) {
		System.out.println("main method started");
		SBISimulator s=new SBISimulator();
		try {
		s.withdrawal(41000);
		}catch(DayLimitException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main method ended");
	}

}
