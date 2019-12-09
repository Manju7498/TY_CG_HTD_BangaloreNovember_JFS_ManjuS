import java.io.FileInputStream;

public class FileInput {

	public static void main(String[] args) {
try {
	FileInputStream f=new FileInputStream("manju.txt");
	int a=f.read();
	System.out.println((char)a);
	int j=0;
	while((j=f.read())!=-1) {
		System.out.println((char)j);
	}
	System.out.println("success");
} catch (Exception e) {
	e.printStackTrace();
}
	}

}
