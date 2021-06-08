package experiments;

import java.lang.reflect.Modifier;

public class Reflection14 {

	public static void main(String[] args) {
		
		//Continuing with modifiers
		//The Reflection API can identify 4095 different modifiers		
		
		for (int i = 0; i<24; i++) {
			System.out.println(Modifier.toString(i));
		}
		System.out.println();
		System.out.println(Modifier.toString(2000));
		System.out.println(Modifier.toString(4095));
		
		//4096 does not work. 1-4095 only
		System.out.println(Modifier.toString(4096));
	}
}
