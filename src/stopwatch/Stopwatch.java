package stopwatch;

/**
 * A Stopwatch that measures elapsed time between a starting time and stopping
 * time, or until the present time.
 * 
 * @author Pasut Kittiprapas
 * @version 1.0
 */
public class Stopwatch {
	/** constant for converting nanoseconds to seconds. */
	private static final double NANOSECONDS = 1.0E-9;
	/** time that the stopwatch was started, in nanoseconds. */
	private long startTime;
	private long stopTime;
	private boolean isRunning;

	/** Start the stopwatch if it is not already running. */
	public void start() {
		if (!this.isRunning) {
			this.startTime = System.nanoTime();
			this.isRunning = true;
		}
	}

	/**
	 * Stop the stopwatch if it is running.
	 */
	public void stop() {
		if (this.isRunning) {
			this.stopTime = System.nanoTime();
			this.isRunning = false;
		}
	}

	/**
	 * Check the stopwatch whether it is running or not.
	 * 
	 * @return true if it is running and false if it isn't.
	 */
	public boolean isRunning() {
		return this.isRunning;
	}

	/**
	 * If the stopwatch is running, then return the elapsed time since start until the current time
	 * but If stopwatch is stopped, then return the time between the start and stop times. 
	 * @return the elapsed time in seconds.
	 */
	public double getElapsed() {
		if (!this.isRunning) {
			return (System.nanoTime() - this.startTime) * this.NANOSECONDS;

		}
		return (stopTime - stopTime) * this.NANOSECONDS;
	}

}
