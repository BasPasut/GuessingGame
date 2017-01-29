package stopwatch;

/**
 * Append chars to String.
 * @author Pasust Kittiprapas
 *
 */
public class AppendString implements Runnable{
	int count;
	public AppendString(int count){
		this.count = count;
	}
	
	@Override
	public void run() {
		final char CHAR = 'a';
		System.out.printf("Append %,d chars to String\n", count);
		String result = ""; 
		int k = 0;
		while(k++ < count) {
			result = result + CHAR;
		}
		System.out.println("final string length = " + result.length());
		
	}
}
