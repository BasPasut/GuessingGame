package stopwatch;

/**
 * Add double primitives from an array.
 * @author Pasut Kittiprapas
 *
 */
public class TestSumDoublePrimitives implements Runnable{
	int counter; 
	static final int ARRAY_SIZE = 500000;
	public TestSumDoublePrimitives(int counter) {
		this.counter = counter;
	}
		@Override
		public void run() {
			System.out.printf("Sum array of double primitives with count=%,d\n", counter);
			Stopwatch timer = new Stopwatch();
			// create array of values to add before we start the timer
			double[] values = new double[ARRAY_SIZE];
			for(int k=0; k<ARRAY_SIZE; k++) values[k] = k+1;
			
			timer.start();
			double sum = 0.0;
			// count = loop counter, i = array index value
			for(int count=0, i=0; count<counter; count++, i++) {
				if (i >= values.length) i = 0;  // reuse the array when get to last value
				sum = sum + values[i];
			}
			System.out.println("sum = " + sum);
	}
}
