package stopwatch;

/**
 * TaskTimer is the tool that used to measure and print the elapsed for specific
 * task.
 * 
 * @author Pasut Kittiprapas
 *
 */
public class TaskTimer {
	
	/**
	 * Run the task and measure the elapsed of the task and print it.
	 * 
	 * @param run
	 */
	public void measureAndPrint(Runnable run) {
		Stopwatch stopwatch = new Stopwatch();
		stopwatch.start();
		run.run();
		stopwatch.stop();
		System.out.printf("Elapsed time %.6f sec\n\n", stopwatch.getElapsed());
	}

}
