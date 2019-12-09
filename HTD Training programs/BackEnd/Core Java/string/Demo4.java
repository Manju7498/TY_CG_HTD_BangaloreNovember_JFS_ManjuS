
public class Demo4 {
	public static void main(String[] args) {
		String s=new String("manju");
		System.out.println(s.hashCode());
		s=s.concat(" goud");
		System.out.println(s.hashCode());
		StringBuffer s1=new StringBuffer("Manju");
		System.out.println(s1.hashCode());
		s1=s1.append(" Goud");
		System.out.println(s1.hashCode());
	}

}
