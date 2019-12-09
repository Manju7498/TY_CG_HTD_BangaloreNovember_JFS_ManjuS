package javaOops;

public class Car1 extends Vehicle {
	int cost=5000;
	void carDetials() {
		int cost=3000;
		System.out.println("local variable cost is "+cost);
		System.out.println("global variable cost is "+this.cost);
		System.out.println("parent class variable cost is "+super.cost);
	}

}
