
public class Array {
	public static void main(String[] args) {
		int a1[]=new int[4];
		a1[0]=20;
		a1[1]=25;
		a1[2]=30;
		a1[3]=35;
		System.out.println(a1.length);
		for(int i=0;i<a1.length;i++)
		{
			System.out.println(a1[i]);
		}
		System.out.println("*************");
	    double a2[]=new double[4];
		a2[0]=20.77;
		a2[1]=25.83;
		a2[2]=30.33;
		System.out.println(a2.length);
		for(int i=0;i<a1.length;i++)
		{
			System.out.println(a2[i]);
		}
		System.out.println("*************");
	    char a3[]=new char[4];
		a3[0]='m';
		a3[1]='a';
		a3[2]=8 ;
		System.out.println(a3.length);
		for(int i=0;i<a1.length;i++)
		{
			System.out.println(a3[i]);
		}
	}

}
