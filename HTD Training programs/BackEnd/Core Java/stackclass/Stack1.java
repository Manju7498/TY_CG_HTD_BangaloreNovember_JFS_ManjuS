import java.util.Stack;

public class Stack1 {
	public static void main(String[] args) {
		Stack s=new Stack();
		s.add(23);
		s.add(45);
		s.add(56);
		s.push(67);
		System.out.println("stack elements : "+s);
		s.pop();
		System.out.println("stack elements : "+s);
		System.out.println("peek : "+s.peek());
		System.out.println("searched ele : "+s.search(23));
		System.out.println("stack elements : "+s);
	}
}
