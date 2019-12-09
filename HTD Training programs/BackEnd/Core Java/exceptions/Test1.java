
public class Test1 {
	public static void main(String[] args) {
		System.out.println("main started");
		int a[]=new int[2];
		a[0]=18;
		a[1]=16;
		try {
			a[2]=24;
		}
		catch(ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("give according to size");
		}
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		System.out.println("main method ended");
	}
}
