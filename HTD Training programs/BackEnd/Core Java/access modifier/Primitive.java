package com.cpgm.access.pack1;

public class Primitive {
	byte a=10;
	short s=a;
	int i=a;
	float f=a;
	double d=a;
	void values() {
		System.out.println("byte value is "+a);
		System.out.println("short value is "+s);
		System.out.println("int value is "+i);
		System.out.println("float value is "+f);
		System.out.println("double value is "+d);
	}
	//explicit typecasting
	double pi=3.14;
	int j=(int)pi;
	short g=(short)pi;
	void evalues() {
		System.out.println("double value is "+pi);
		System.out.println("int value is "+j);
		System.out.println("short value is "+g);
	}
	

}
