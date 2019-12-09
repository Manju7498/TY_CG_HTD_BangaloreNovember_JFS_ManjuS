import java.util.HashSet;

public class HashSet1 {

	public static void main(String[] args) {
		HashSet hs=new HashSet();
		hs.add(18);
		hs.add(24);
		hs.add(null);
		hs.add(16);
		hs.add(null);
		hs.add(24);
		for (Object obj : hs) {
			System.out.println(obj/* + " & hashcode : "+obj.hashCode()*/);
		}
		HashSet<String> hs1=new HashSet<String>();
		hs1.add("manju");
		hs1.add("gayathri");
		hs1.add("pranitha");
		hs1.add(null);
		hs1.add("manju");
		for (Object obj : hs1) {
			System.out.println(obj /*+ " & hashcode : "+obj.hashCode()*/);
		}
		}

}
