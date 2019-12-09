
public class Robot implements Moment,Sound {

	@Override
	public void talk() {
		System.out.println("robot is talking");
		
	}

	@Override
	public void move() {
		System.out.println("robot is moving");
	}
	public static void main(String[] args) {
		Robot r=new Robot();
		r.move();
		r.talk();
		System.out.println("************");
		Moment m=new Robot();
		m.move();
		Sound s=new Robot();
		s.talk();
	}

}
