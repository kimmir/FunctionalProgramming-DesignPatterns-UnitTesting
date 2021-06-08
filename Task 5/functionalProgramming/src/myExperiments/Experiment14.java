package myExperiments;

import java.io.BufferedReader;
import java.io.FileReader;

public class Experiment14 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader r = new BufferedReader(new FileReader("data/Drivers.txt"));
		r.lines().forEach(line -> System.out.println(line));
		r.close();
	}
}
