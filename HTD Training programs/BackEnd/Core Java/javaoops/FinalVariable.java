package javaOops;

public class FinalVariable
{
	final double PI;
	final int b;
	static final int c;
	int a;
	//Using Constructor
	FinalVariable(double PI)
	{
		this.PI=PI;
	}
	FinalVariable(double PI,int a) 
	{
		this.PI=PI;
		this.a=a;

	}
	void print()
	{
		System.out.println(PI);
		System.out.println(a);
}
	//Using IIB
	{
		System.out.println("**IIB started**");
		b=49;//this.b=49;
		System.out.println(b);
		System.out.println("**IIB completed**");
	}
	//Using SIB
	static {
		System.out.println("**SIB started**");
		c=64;
		System.out.println(c);
		System.out.println("**SIB completed**");
	}
}
