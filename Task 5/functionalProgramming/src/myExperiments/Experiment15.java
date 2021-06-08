package myExperiments;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Experiment15 {
	public static void main(String[] args) throws IOException  {
						
		try (Stream<String> lines = Files.lines(Path.of("data/Drivers.txt"))) {			
			List<Driver> table = lines.map(line -> {
				String[] values = line.split(",");
				return new Driver(
						values[0],
						Integer.parseInt(values[1]),
						values[2],
						values[3],
						Integer.parseInt(values[4]),
						Integer.parseInt(values[5]),
						Integer.parseInt(values[6]),
						Integer.parseInt(values[7]),
						Integer.parseInt(values[8]),
						Integer.parseInt(values[9]),
						values[10],
						Integer.parseInt(values[11]));
				
			}).collect(Collectors.toList());				
			table.forEach(System.out::println);
		}				
	}
}
