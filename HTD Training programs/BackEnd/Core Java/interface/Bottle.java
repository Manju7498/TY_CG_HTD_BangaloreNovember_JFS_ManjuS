
public interface Bottle
{
	void open();
	void drink();
	default void close()
	   {
		System.out.println("close bottle");
	    }
	static void juice() 
	{
		System.out.println("juice is ready");
	}

}
