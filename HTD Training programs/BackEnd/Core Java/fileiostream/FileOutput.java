
import java.io.FileOutputStream;

public class FileOutput {

	public static void main(String[] args) {
		try {
			FileOutputStream f=new FileOutputStream("manju.txt");
			String s="manju";
			byte[] b=s.getBytes();
			System.out.println("success.......");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
