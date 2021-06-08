package myExperiments;

public class Driver implements Comparable<Driver>{

	private String driver;	
	private int age;
	private String carType;
	private String carColour;
	private int numCarDoors;
	private int yearsLicenseHeld;
	private int yearsNoClaims;	
	private int pointsOnLicense;	
	private int numCarsOwned;
	private int previousCarsOwned;
	private String insuranceProvider;
	private int monthlyInsuranceCost;
	
	public Driver(String driver,int age,String carType,String carColour,int numCarDoors, 
			int yearsLicenseHeld, int yearsNoClaims,int pointsOnLicense,int numCarsOwned,
			int previousCarsOwned,String insuranceProvider,
			int monthlyInsuranceCost) {
		
		this.driver = driver;
		this.age = age;
		this.carType = carType;
		this.carColour = carColour;
		this.numCarDoors = numCarDoors;
		this.yearsLicenseHeld = yearsLicenseHeld;
		this.yearsNoClaims = yearsNoClaims;
		this.pointsOnLicense = pointsOnLicense;
		this.numCarsOwned = numCarsOwned;
		this.previousCarsOwned = previousCarsOwned;
		this.insuranceProvider = insuranceProvider;
		this.monthlyInsuranceCost = monthlyInsuranceCost;
	}
	
	public String toString() {
	    return String.format("%-15s%-10d%10d%10d%10d", driver, age, yearsLicenseHeld,
	        yearsNoClaims, monthlyInsuranceCost);				
	}

	public String getDriver() {
		return driver;
	}


	public void setDriver(String driver) {
		this.driver = driver;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getCarType() {
		return carType;
	}


	public void setCarType(String carType) {
		this.carType = carType;
	}


	public String getCarColour() {
		return carColour;
	}


	public void setCarColour(String carColour) {
		this.carColour = carColour;
	}


	public int getNumCarDoors() {
		return numCarDoors;
	}


	public void setNumCarDoors(int numCarDoors) {
		this.numCarDoors = numCarDoors;
	}


	public int getYearsLicenseHeld() {
		return yearsLicenseHeld;
	}


	public void setYearsLicenseHeld(int yearsLicenseHeld) {
		this.yearsLicenseHeld = yearsLicenseHeld;
	}


	public int getYearsNoClaims() {
		return yearsNoClaims;
	}


	public void setYearsNoClaims(int yearsNoClaims) {
		this.yearsNoClaims = yearsNoClaims;
	}


	public int getPointsOnLicense() {
		return pointsOnLicense;
	}


	public void setPointsOnLicense(int pointsOnLicense) {
		this.pointsOnLicense = pointsOnLicense;
	}


	public int getNumCarsOwned() {
		return numCarsOwned;
	}


	public void setNumCarsOwned(int numCarsOwned) {
		this.numCarsOwned = numCarsOwned;
	}


	public int getPreviousCarsOwned() {
		return previousCarsOwned;
	}


	public void setPreviousCarsOwned(int previousCarsOwned) {
		this.previousCarsOwned = previousCarsOwned;
	}


	public String getInsuranceProvider() {
		return insuranceProvider;
	}


	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}


	public int getMonthlyInsuranceCost() {
		return monthlyInsuranceCost;
	}


	public void setMonthlyInsuranceCost(int monthlyInsuranceCost) {
		this.monthlyInsuranceCost = monthlyInsuranceCost;
	}
	
	public int compareTo(Driver arg0) {		
		 return ((Integer) monthlyInsuranceCost).compareTo(arg0.monthlyInsuranceCost);
	}
}
