import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class TestB {
	public static void main(String[] args) {
		ArrayList<Integer> a1=new ArrayList<Integer>();
		a1.add(23);
		a1.add(16);
		a1.add(74);
		a1.add(33);
		a1.add(24);
		List l1=a1.stream().filter(i -> i%2 == 0).collect(Collectors.toList());	
		System.out.println(l1);
		List l2=a1.stream().map(i -> i*100).collect(Collectors.toList());
		System.out.println(l2);
		Optional<Integer> a2=a1.stream().max((i,j)->i.compareTo(j));
		System.out.println(a2);
		System.out.println(a1.size());
		System.out.println(a1.stream().count());
		}

}
