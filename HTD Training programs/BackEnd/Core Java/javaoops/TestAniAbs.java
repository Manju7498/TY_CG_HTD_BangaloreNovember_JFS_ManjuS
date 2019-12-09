package javaOops;

public class TestAniAbs {
	public static void main(String[] args) {
		DogAbs d=new DogAbs("Tiger");
		System.out.println(d.name);
		AnimalAbstract a=new DogAbs("pinky");
		System.out.println(a.name);
	}

}
