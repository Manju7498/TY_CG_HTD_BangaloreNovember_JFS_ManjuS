package javaOops;

public class TestAbsVehicle {
	public static void main(String[] args) {
		CarAbstract c=new CarAbstract();
		c.start();
		c.stop();
		System.out.println("******************");
		VehicleAbstract v=new  CarAbstract();
		v.start();
		v.stop();
	}

}
