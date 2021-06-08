package myExperiments;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.*;

public class Experiment17 {
				
	public static void main(String[] args) throws IOException {
		
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
		
		JFrame f = new JFrame();
		
		JPanel p1,p2;
		p1 = new JPanel();
		p2 = new JPanel();
						
		JButton b1 = new JButton("Stream() Data");
		JButton b2 = new JButton("parallelStream() Data");
		JButton b3 = new JButton("Line Separator");
		JButton b4 = new JButton("Stream() : Sorted No Claims");
		JButton b5 = new JButton("parallelStream(): Sorted No Claims");
		
		p1.setLayout(new GridLayout(0,4));
		p1.add(b1, BorderLayout.CENTER);
		p1.add(b2, BorderLayout.SOUTH);
		p1.add(b3, BorderLayout.WEST);
		p1.add(b4, BorderLayout.EAST);
		p1.add(b5, BorderLayout.NORTH);
							
		b1.addActionListener(event -> table.stream().forEach(driver -> System.out.println(driver)));
		b2.addActionListener(event -> table.parallelStream().forEach(driver -> System.out.println(driver)));
		b3.addActionListener(event -> System.out.println("-----------------------"));
		b4.addActionListener(event -> table.stream().sorted((x1,x2) -> ((Integer) x1.getYearsNoClaims()).compareTo(x2.getYearsNoClaims())).forEach(System.out::println));
		b5.addActionListener(event -> table.parallelStream().sorted((x1,x2) -> ((Integer) x1.getYearsNoClaims()).compareTo(x2.getYearsNoClaims())).forEach(System.out::println));
		
		
		f.getContentPane().add(p1,BorderLayout.NORTH);
		//f.getContentPane().add(p2,BorderLayout.SOUTH);
		
		f.pack();
		f.setVisible(true);
	}
}
