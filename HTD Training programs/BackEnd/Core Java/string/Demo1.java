
public class Demo1 {
	public static void main(String[] args) {
		String s1="manju";
		System.out.println(s1.hashCode());
		String s2="pranitha";
		System.out.println(s2.hashCode());
		s1="priya";
		System.out.println(s1.hashCode());
		String s3="manju";
		System.out.println(s3.hashCode());
		System.out.println("************************");
		String s4=new String("uday");
		System.out.println(s4.hashCode());
		String s5=new String("syamala");
		System.out.println(s5.hashCode());
		String s6=new String("uday");
		System.out.println(s6.hashCode());
		s4=new String("mounika");
		System.out.println(s4.hashCode());
		
	}

}
