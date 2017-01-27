package Week1;
import java.time.Duration;
public class Problem2 {
	public static void main(String[] args) {
		System.out.print("Duration(nanosecs) : ");
		System.out.println(System.nanoTime());
		long timeRemaining = Long.MAX_VALUE - System.nanoTime();
		System.out.print("Years left : ");
		System.out.println((Duration.ofNanos(timeRemaining).toDays())/365.242);
		
	}
	
}
