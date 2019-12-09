
public class Test {
		void write() {
			String st="manju";
			try {
				System.out.println("length of string is "+st.length());
			}
			catch (NullPointerException e) {
				System.out.println("null doesn't have length");
			}
		}
		public static void main(String[] args) {
			System.out.println("main method started");
			Test t=new Test();
			t.write();
			System.out.println("main  method ended");
		}
}
