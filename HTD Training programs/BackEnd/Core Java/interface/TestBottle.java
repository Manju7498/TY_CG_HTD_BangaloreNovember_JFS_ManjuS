
public class TestBottle {
	public static void main(String[] args) {
		Pepsi p=new Pepsi();
		p.open();
		p.drink();
		p.close();
		Fanta f=new Fanta();
		f.open();
		f.drink();
		f.close();
		Bottle.juice();
	}

}
