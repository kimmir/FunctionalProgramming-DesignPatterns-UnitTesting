package unitTesting;

import static testFramework.UnitFramework.*;

public class Main {
	
	public static void main(String[] args) {
		TestUnitTest tu = new TestUnitTest();
		runChecks(tu);
		report();
	}
}
