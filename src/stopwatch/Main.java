package stopwatch;

public class Main {
	
	public static void main(String[] args) {
		AppendString appendString = new AppendString(50000);
		AppendString appendString2 = new AppendString(100000);
		AppendStringBuilder appendStringBuilder = new AppendStringBuilder(100000);
		TestSumDoublePrimitives testSumDoublePrivitives = new TestSumDoublePrimitives(1000000000);
		TestSumDouble testSumDouble = new TestSumDouble(1000000000);
		TestSumBigDecimal testSumBigDecimal = new TestSumBigDecimal(1000000000);
		
		TaskTimer t1 = new TaskTimer();
		t1.measureAndPrint(appendString);
		t1.measureAndPrint(appendString2);
		t1.measureAndPrint(appendStringBuilder);
		t1.measureAndPrint(testSumDoublePrivitives);
		t1.measureAndPrint(testSumDouble);
		t1.measureAndPrint(testSumBigDecimal);
		
	}
}
