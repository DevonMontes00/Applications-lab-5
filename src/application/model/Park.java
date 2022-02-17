package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Park {
	
	String parkName;
	HashMap<Zone, ArrayList<Dinosaur>> map = new HashMap<Zone, ArrayList<Dinosaur>>();
	ArrayList<Dinosaur> dinoAL;
	ArrayList<Zone> zoneAL;
	
	public Park(String parkName, HashMap <Zone, ArrayList<Dinosaur>> map)
	{
		this.parkName = parkName;
		this.map = map;
		this.dinoAL = new ArrayList<Dinosaur>();
		this.zoneAL = new ArrayList<Zone>();
	}
	
	/**
	 * Setter for park name
	 * 
	 * @author iog693
	 * @param String for the new park name
	 */
	public void setParkName(String parkName)
	{
		this.parkName = parkName;
	}
	
	/**
	 * Getter for park name
	 * 
	 * @author iog693
	 * @return park name
	 */
	public String getParkName()
	{
		return parkName;
	}
	
	/**
	 * Setter for HashMap
	 * 
	 * @author iog693
	 * @param New Hashmap
	 */
	public void setHashMap(HashMap<Zone, ArrayList<Dinosaur>> map)
	{
		this.map = map;
	}
	
	/**
	 * Getter for HashMap
	 * 
	 * @author iog693
	 * @return HashMap
	 */
	public HashMap<Zone, ArrayList<Dinosaur>> getHashMap()
	{
		return map;
	}
	
	/**
	 * Setter for dinoAL
	 * 
	 * @author iog694
	 * @param ArrayList of Dinosaur objects
	 */
	public void setDinoAL(ArrayList<Dinosaur> dinoAL)
	{
		this.dinoAL = dinoAL;
	}
	
	/**
	 * Getter for dinoAL
	 * 
	 * @author iog693
	 * @return Dinosaur ArrayList
	 */
	public ArrayList<Dinosaur> getDinoAL()
	{
		return dinoAL;
	}
	
	/**
	 * Setter for zoneAL
	 * 
	 * @author iog693
	 * @param New ArrayList of Zone objects
	 */
	public void setZoneAL(ArrayList<Zone> zoneAL)
	{
		this.zoneAL = zoneAL;
	}
	
	/**
	 * Getter for zoneAL
	 * 
	 * @author iog693
	 * @return zoneAL
	 */
	public ArrayList<Zone> getZoneAL()
	{
		return zoneAL;
	}
	
	/**
	 * To String function for park object
	 * 
	 * @author iog693
	 * @return parkName
	 */
	public String toString()
	{
		return parkName;
	}
	
	/**
	 * Adds dino object to dinoAL
	 * 
	 * @author iog693
	 * @param Dino object
	 */
	public void addDino(Dinosaur d)
	{
		dinoAL.add(d);
	}
	
	/**
	 * Adds zone object to zoneAL
	 * 
	 * @author iog693
	 * @param Zone object
	 */
	public void addZone(Zone z)
	{
		zoneAL.add(z);
	}
	
	/**
	 * Loads Dinosaur objects from file into dinoAL
	 * 
	 * @author iog693
	 * @param File name of file that contains dino objects
	 */
	public void loadDino(String filename)
	{
		File file = new File(filename);
		
		try 
		{
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext())
			{
				String data = inputStream.nextLine();
				String [] dataComponents = data.split(",");
				String dinoName = dataComponents[0];
				String dinoType = dataComponents[1];
				String dinoCarn = dataComponents[2];
				String dinoZone = dataComponents[3];
				
				Dinosaur d = new Dinosaur(dinoName, dinoType, dinoCarn, dinoZone);
				addDino(d);
			}
			inputStream.close();
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads Zone objects from file into zinoAL
	 * 
	 * @author iog693
	 * @param File name of file that contains zone objects
	 */
	public void loadZones(String filename)
	{
		File file = new File(filename);
		
		try 
		{
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext())
			{
				String data = inputStream.nextLine();
				String [] dataComponents = data.split(",");
				String zoneName = dataComponents[0];
				String threatLevel = dataComponents[1];
				String zoneCode = dataComponents[2];
				
				Zone z = new Zone(zoneName, zoneCode, threatLevel);
				addZone(z);
			}
			inputStream.close();
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates HashMap of each zone and every dinosaur in the zones
	 * @param Zone arraylist of park zones
	 * @param Dino arraylist of dinosaurs
	 * @return HashMap
	 */
	public HashMap<Zone, ArrayList<Dinosaur>> createMap(ArrayList<Zone> zoneAL, ArrayList<Dinosaur> dinoAL)
	{
		HashMap<Zone, ArrayList<Dinosaur>> map = new HashMap<Zone, ArrayList<Dinosaur>>();
		int i;
		int j;
		
		for(i = 0; i < zoneAL.size(); i++)
		{
			ArrayList<Dinosaur> newDinoAL = new ArrayList<Dinosaur>();
			for(j = 0; j < dinoAL.size(); j++)
			{
				if(dinoAL.get(j).getDinoZone().equals(zoneAL.get(i).getZoneCode()))
				{
					newDinoAL.add(dinoAL.get(j));
				}
			}
			map.put(zoneAL.get(i), newDinoAL);
		}
		
		return map;
	}
	

}
