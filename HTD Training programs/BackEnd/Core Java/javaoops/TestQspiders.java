package javaOops;

public class TestQspiders {
	public static void main(String[] args) {
		Qspiders btm=new Qspiders();
		btm.swipe();
		btm.swipe();
		Qspiders btr=new Qspiders();
		btr.swipe();
		System.out.println("BTM count is "+btm.branchStudCount);
		System.out.println("BTR count is "+btr.branchStudCount);
		System.out.println("Total count is "+Qspiders.totalStudCount);
	}

}
