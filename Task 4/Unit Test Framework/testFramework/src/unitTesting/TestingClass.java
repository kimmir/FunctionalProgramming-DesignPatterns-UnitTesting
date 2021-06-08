package unitTesting;

public class TestingClass {
	
	public String stringA = "First String";
	private String stringB = "Second String";
	
	public float floatA = 1.5f;
	private float floatB = 7f;
	
	//---------------------------------------
	//Constructors
	//---------------------------------------
	
	public TestingClass()
	{	
		
	}
	
	public TestingClass(String strA, String strB, float floatA, float floatB)
	{
		this.stringA = strA;
		this.stringB = strB;
		this.floatA = floatA;
		this.floatB = floatB;
	}
	
	//---------------------------------------
	//Float Methods
	//---------------------------------------
	
	public void squareA()
	{
		this.floatA *= this.floatA;
	}
	
	private void squareB()
	{
		this.floatB *= this.floatB;
	}
	
	public float getFloatA()
	{
		return floatA;
	}
	
	private void setFloatA(float floatA)
	{
		this.floatA = floatA;		
	}
	
	public float getFloatB()
	{
		return floatB;
	}
	
	public void setFloatB(float floatB)
	{
		this.floatB = floatB;
	}
			
	//---------------------------------------
	//String Methods
	//---------------------------------------
	
	public String getStringA()
	{
		return stringA;
	}
	
	private void setStringA(String stringA)
	{
		this.stringA = stringA;
	}
	
	public String getStringB()
	{
		return stringB;
	}
	
	public void setStringB(String stringB)
	{
		this.stringB = stringB;
		
	}
	
	public String concatinatePublicString(String stringA)
	{
		return String.format("%s %s", stringA,stringA);
	}
	
	private String concatinatePrivateString(String stringB)
	{
		return this.stringB = String.format("%s %s", stringB,stringB);
	}
	
	public String doesStringContain(String searchText, String stringA, String stringB)
	{
		String returnStr = "";
		if (stringA.contains(searchText))
		{
			returnStr = returnStr + "stringA Does Contain: " + searchText + " |" ;
		}
		if (stringB.contains(searchText))
		{
			returnStr = returnStr + "stringB Does Contain: " + searchText + " |";
		}
		return returnStr;
	}
	
	//---------------------------------------
	//String & Float Methods
	//---------------------------------------
	
	public String toString()
	{		
		return String.format("(floatA: %f, floatB: %f, stringA: %s, stringB: %s)", floatA,floatB,stringA,stringB);
	}
		
}
