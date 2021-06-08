package myExperiments;

import java.util.Arrays;
import java.util.List;

public class Experiment4 {
	public static void main(String[] args) {
		List<Driver> table = Arrays.asList(
				new Driver("Kim", 21, "Hatchback", "Silver", 5, 2, 1, 0, 1, 0, "Provider1", 100),
				new Driver("Dave", 25, "Hatchback", "Black", 5, 5, 5, 0, 1, 1, "Provider2", 80),
				new Driver("Leanne", 30, "Sport", "Red", 3, 11, 7, 3, 2, 1, "Provider3", 200),
				new Driver("Mike", 42, "SUV", "White", 5, 20, 10, 0, 1, 3, "Provider4", 50),
				new Driver("Sarah", 28, "Hatchback", "Grey", 5, 8, 4, 3, 1, 1, "Provider5", 90),
				new Driver("Jennie", 24, "Sport", "Silver", 3, 6, 5, 0, 1, 0, "Provider6", 220),
				new Driver("Kevin", 33, "Hatchback", "Blue", 5, 8, 7, 5, 1, 1, "Provider7", 60),
				new Driver("Lia", 21, "SUV", "Black", 5, 3, 3, 0, 1, 0, "Provider8", 175)
				);
		
		System.out.println("Several people own hatchbacks");
		table.stream().filter(driver->driver.getCarType() == "Hatchback")
			.forEach(System.out::println);
		
		System.out.println();
		System.out.println("People with black cars");
		table.stream().filter(driver->driver.getCarColour() == "Black")
			.forEach(System.out::println);
	}
}
