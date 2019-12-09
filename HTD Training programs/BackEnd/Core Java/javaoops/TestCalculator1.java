package javaOops;

public class TestCalculator1 {
public static void main(String[] args) {
	Calculator1 c1=new Calculator1();
	int r1=c1.add(45);
	System.out.println("result 1 is "+r1);
	int r2=c1.add(45,55);
	System.out.println("result 2 is "+r2);
	double r3=c1.add(45.87);
	System.out.println("result 3 is "+r3);
	int r4=Calculator1.mul(5);
	System.out.println("result 4 is "+r4);
	int r5=Calculator1.mul(5,9);
	System.out.println("result 5 is "+r5);
	double r6=Calculator1.mul(5.6);
	System.out.println("result 6 is "+r6);
}
}
