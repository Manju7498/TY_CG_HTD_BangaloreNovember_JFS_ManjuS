
public class Son implements Father1,Father2 {

	@Override
	public void home() {
		Father2.super.home();
	}
	public static void main(String[] args) {
		Son s=new Son();
		s.home();
	}
}
