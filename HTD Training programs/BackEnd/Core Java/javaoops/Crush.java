package javaOops;

public class Crush {
	void receive(Phone p) {
		if(p instanceof BasicSet)
		{
			System.out.println("thanks");
		}
		else if(p instanceof Oppo)
		{
			System.out.println("thank you");
		}
		else if(p instanceof Oneplus)
		{
			System.out.println("thank you so much");
		}
		else if(p instanceof Apple)
		{
			System.out.println("thanks dear");
		}
		else 
		{
			System.out.println("dobbey");
		}
	}

}
