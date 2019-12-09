package javaOops;

public class TestHeroHonda {
	public static void main(String[] args) {
		Hero h=new Hero();
		h.design();
		h.engine();
		System.out.println("*************");
		Honda h1=new Hero();
		h1.design();
		h1.engine();
		System.out.println("**************");
		HeroHonda h2=new Hero();
		h2.design();
		h2.engine();
	}

}
