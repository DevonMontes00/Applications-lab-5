package application.model;

public class Dinosaur {
	
	String dinoName;
	String dinoType;
	String carnIndi;
	String dinoZone;
	
	public Dinosaur(String dinoName, String dinoType, String carnIndi, String dinoZone)
	{
		this.dinoName = dinoName;
		this.dinoType = dinoType;
		this.carnIndi = carnIndi;
		this.dinoZone = dinoZone;
	}
	
	/**
	 * Getter for DinoName
	 * 
	 * @author iog693
	 * @return Dino name
	 */
	public String getDinoName()
	{
		return dinoName;
	}
	
	/**
	 * Setter for Dino Name
	 * 
	 * @author iog693
	 * @param String of new dino name
	 */
	public void setDinoName(String n)
	{
		this.dinoName = n;
	}
	
	/**
	 * Getter for Dino Type
	 * 
	 * @author iog693
	 * @return dino type
	 */
	public String getDinoType()
	{
		return dinoType;
	}
	
	/**
	 * Setter for Dino Type
	 * 
	 * @author iog693
	 * @param String for new dino type
	 */
	public void setDinoType(String t)
	{
		this.dinoType = t;
	}
	
	/**
	 * Getter for carnIndi
	 * 
	 * @author iog693
	 * @return CarnIndi
	 */
	public String getCarnIndi()
	{
		return carnIndi;
	}
	
	/**
	 * Setter for carnIndi
	 * 
	 * @author iog693
	 * @param String for new carnIndi
	 */
	public void setCarnIndi(String c)
	{
		this.carnIndi = c;
	}
	
	/**
	 * Getter for Dino Zone
	 * 
	 * @author iog693
	 * @return Dino Zone
	 */
	public String getDinoZone()
	{
		return dinoZone;
	}
	
	/**
	 * Setter for dino zone
	 * 
	 * @author iog693
	 * @param String for new dinozone
	 */
	public void setDinoZone(String z)
	{
		this.dinoZone = z;
	}
	
	/**
	 * To string for Dinosaur object
	 * 
	 * @author iog693
	 * @return String of dino object
	 */
	public String toString()
	{
		String print = dinoName + " - " + dinoType + " - " + carnIndi + "\n";
		return print;
	}

}
