package javaOops;

public class TestAtm {
	public static void main(String[] args) {
		Atm a=new Atm();
		Bank b=new Bank();
		Sbi s=new Sbi();
		Hdfc h=new Hdfc();
		a.depositmoney(s);
	}

}
