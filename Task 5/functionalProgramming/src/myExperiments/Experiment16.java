package myExperiments;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Experiment16 {
	
	public void fileExists(String filePath) throws IOException {
		File f = new File(filePath);
		if (f.exists() && f.isDirectory()) {
			f.delete();			
		} 
		f.createNewFile();
	}
	
	public void results(List<Driver> data, String filePath) throws IOException {
		FileWriter fw = new FileWriter(filePath);
		data.forEach(x -> {
			try {
				fw.write(String.valueOf(x.getYearsLicenseHeld()));
				fw.append('\n');
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		fw.close();
	}
	
	public void run() throws IOException {
		List<Driver> table;
		
		try (Stream<String> lines = Files.lines(Path.of("data/Drivers.txt"))) {			
			 table = lines.map(line -> {
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
		}
		System.out.println("Stream");
		List<Driver> result1 = table.stream().sorted((x1,x2) -> ((Integer) x1.getYearsLicenseHeld()).compareTo(x2.getYearsLicenseHeld())).collect(Collectors.toList());
		result1.forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("Parallel Stream");
		List<Driver> result2 = table.parallelStream().sorted((x1,x2) -> ((Integer) x1.getYearsLicenseHeld()).compareTo(x2.getYearsLicenseHeld())).collect(Collectors.toList());
		result2.forEach(System.out::println);
		
		fileExists("data/StreamResults.txt");
		results(result1, "data/StreamResults.txt");
		
		fileExists("data/ParallelStreamResults.txt");
		results(result2, "data/ParallelStreamResults.txt");
	}
	
	public static void main(String[] args) throws IOException {
		new Experiment16().run();		
	}
}
