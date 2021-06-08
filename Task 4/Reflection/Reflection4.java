package experiments;

public class Reflection4 {
		
	public static void main(String[] args) {
		
		//This reflection is about looking at what information can be gathered about the class
		//Focusing on the .getClass() to see what is available that isn't related to methods/fields
		
		TestingClass testingClass = new TestingClass();
		
		//These checks show that basic information can be obtained easily
		System.out.println("Class: " + testingClass.getClass()); //Returns Package.ClassName
		System.out.println("Class Name: " + testingClass.getClass().getName()); //Returns Package.ClassName
		System.out.println("Simple Name" + testingClass.getClass().getSimpleName()); //Returns TestingClass
		System.out.println("Package Name: " + testingClass.getClass().getPackageName()); //Returns experiments
		System.out.println("Superclass: " + testingClass.getClass().getSuperclass()); //Returns java.lang.object 
		
		//The checks demonstrate that all sorts of Class related information can be obtained
		//Information such as finding out exactly what the class is as well as other classes that may be related
		//There are more functions but they would it be a long list to demonstrate them all
		System.out.println("Primitive: " + testingClass.getClass().isPrimitive()); 
		System.out.println("Synthetic: " + testingClass.getClass().isSynthetic());
		System.out.println("Record: " + testingClass.getClass().isRecord());
		System.out.println("Member Class: " + testingClass.getClass().isMemberClass());
		System.out.println("Local Class: " + testingClass.getClass().isLocalClass());
		System.out.println("Interface: " + testingClass.getClass().isInterface());
		
		
	}
}
