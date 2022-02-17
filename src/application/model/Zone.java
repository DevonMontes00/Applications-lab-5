package application.model;

public class Zone {
	
	String zoneName;
	String zoneCode;
	String threatLevel;
	
	public Zone(String zoneName, String zoneCode, String threatLevel)
	{
		this.zoneName = zoneName;
		this.zoneCode = zoneCode;
		this.threatLevel = threatLevel;
	}
	
	/**
	 * Getter for Zone Name
	 * 
	 * @author iog693
	 * @return Zone name
	 */
	public String getZoneName()
	{
		return zoneName;
	}
	
	/**
	 * Setter for zone name
	 * 
	 * @author iog693
	 * @param String of new zoneName
	 */
	public void setZoneName(String z)
	{
		this.zoneName = z;
	}
	
	/**
	 * Getter for zone code
	 * 
	 * @author iog693
	 * @return zoneCode
	 */
	public String getZoneCode()
	{
		return zoneCode;
	}
	
	/**
	 * Setter for zone code
	 * 
	 * @author iog693
	 * @param String of new zone code
	 */
	public void setZoneCode(String z)
	{
		this.zoneCode = z;
	}
	
	/**
	 * Getter for threat level
	 * 
	 * @author iog693
	 * @return threatlevel
	 */
	public String getThreatLevel()
	{
		return threatLevel;
	}
	
	/**
	 * Setter for threat level
	 * 
	 * @author iog693
	 * @param String of threatlevel
	 */
	public void setThreatLevel(String t)
	{
		this.threatLevel = t;
	}
	
	/**
	 * To string function for zone object
	 * 
	 * @author iog693
	 * @return String of zone object
	 */
	public String toString()
	{
		return zoneName;
	}
	
}
