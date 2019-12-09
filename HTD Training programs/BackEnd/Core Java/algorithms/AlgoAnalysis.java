import java.time.Duration;
import java.time.Instant;

public class AlgoAnalysis {
	public static void main(String[] args) {
		countingDuration2();
		countingDuration1();
	}

	public static long addUpto(Long num) {
		long total=0L;
		for (int i = 0; i < num; i++) {
			total=total+i;
		}
		return total;
	}

	public static long addUptoquick(Long num) {
		return num*(num+1)/2;
	}

	public static void countingDuration1() {
		long num=999999999L;
		Instant start=Instant.now();
		System.out.println("addUpto : "+addUpto(num));
		Instant end=Instant.now();
		long duration=Duration.between(start, end).toNanos();
		double seconds=duration/1000;
		System.out.println("addUpto time : "+seconds+ " nanoseconds  ");
	}
	
	public static void countingDuration2() {
		long num=99999999L;
		Instant start=Instant.now();
		System.out.println("addUpto : "+addUptoquick(num));
		Instant end=Instant.now();
		long duration=Duration.between(start, end).toNanos();
		double seconds=duration/1000;
		System.out.println("addUptoQuick time : "+seconds+ " nanoseconds  ");
	}
}
