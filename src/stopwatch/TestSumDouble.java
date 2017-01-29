package stopwatch;

/**
 * Add Double objects from an array.
 * @author Pasut Kittiprapas
 *
 */
public class TestSumDouble implements Runnable {
	int counter;
	static final int ARRAY_SIZE = 500000;
	
	/**
	 * To intialize TestSumDouble with the counter.
	 * @param counter
	 */
	public TestSumDouble(int counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("Sum array of Double objects with count=%,d\n", counter);
		Stopwatch timer = new Stopwatch();
		// create array of values to add, before we start the timer
		Double[] values = new Double[ARRAY_SIZE];
		for (int i = 0; i < ARRAY_SIZE; i++)
			values[i] = new Double(i + 1);

		timer.start();
		Double sum = new Double(0.0);
		// count = loop counter, i = array index
		for (int count = 0, i = 0; count < counter; count++, i++) {
			if (i >= values.length)
				i = 0;
			sum = sum + values[i];
		}
		System.out.println("sum = " + sum);
	}
}
