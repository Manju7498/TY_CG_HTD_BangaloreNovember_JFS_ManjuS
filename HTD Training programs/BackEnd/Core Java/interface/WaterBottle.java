
public interface WaterBottle  extends Bottle{
	public default void close() {
		System.out.println("subclass");
	}

}
