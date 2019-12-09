
public class Car {
	/*Vehicle v= ()-> {
		System.out.println("car is moving");
	};
	Vehicle v= a-> {
		System.out.println("car is moving");
	};*/
	Vehicle v= (a,b)-> {
		System.out.println("car is moving");
	};
	public static void main(String[] args) {
		Car c=new Car();
		/*c.v.move();
		/*c.v.move1(10);*/
		c.v.move(10,20);
	}

}
