package javaOops;

public class TestGenerations {
	public static void main(String[] args) {
		/*System.out.println("first genaration features");
		FirstGeneration fg=new FirstGeneration();
		fg.call();
		fg.msg();
		System.out.println("second genaration features");
		SecondGenaration sg=new SecondGenaration();
		sg.call();
		sg.msg();
		sg.radio();
		System.out.println("third genaration features");
		ThirdGeneration tg=new ThirdGeneration();
		tg.call();
		tg.msg();
		tg.radio();
		tg.camera();*/
		FirstGeneration fg=new ThirdGeneration();
		fg.call();
		fg.msg();
		SecondGenaration sg=new ThirdGeneration();
		sg.call();
		sg.msg();
		sg.radio();
		ThirdGeneration tg=new ThirdGeneration();
		tg.call();
		tg.msg();
		tg.radio();
		tg.camera();
		//ThirdGeneration fg=(ThirdGeneration)new FirstGeneration();
		
	}

}
