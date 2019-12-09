
public class Demo2 {
	public static void main(String[] args) {
		String s=new String("    manju s      ");
		System.out.println(s.trim());
		String s1=new String("Syamala");
		System.out.println(s1.toLowerCase());
		System.out.println(s1.toUpperCase());
		System.out.println(s1.substring(4));
		System.out.println(s1.charAt(3));
		System.out.println(s1.isEmpty());
		System.out.println(s1.substring(4,7));
		System.out.println(s1.indexOf('a'));
		System.out.println(s1.indexOf("la"));
		System.out.println(s1.indexOf('a',3));
		System.out.println(s1.indexOf("ma",3));
	}

}
