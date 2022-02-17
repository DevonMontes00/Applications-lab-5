package application.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import application.Main;
import application.model.Dinosaur;
import application.model.Park;
import application.model.Zone;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ZoneController {
	
	@FXML
	Label zoneLabel;
	
	@FXML
	Label numDinosaurs;
	
	@FXML
	Label threatLevel;
	
	@FXML
	Label succsessTextAdd;
	
	@FXML
	Label succsessTextRelocate;
	
	@FXML
	TextArea dinoList;
	
	@FXML
	TextField addDinoName;
	
	@FXML
	TextField addDinoType;
	
	@FXML
	RadioButton yes;
	
	@FXML
	RadioButton no;
	
	@FXML
	TextField relocateDinoName;
	
	@FXML
	TextField relocateDinoZone;
	
	@FXML
	Button add;
	
	@FXML
	Button relocate;
	
	String zone;
	
	HashMap<Zone, ArrayList<Dinosaur>> map = new HashMap<Zone, ArrayList<Dinosaur>>();
	
	public ZoneController(String zone)
	{
		this.zone = zone;
	}
	
	/**
	 * Initializes zone view
	 * 
	 * @author iog693
	 */
	public void initialize()
	{
		Park jp = new Park("Jurassic Park", map);
		jp.loadZones("data/zones.csv");
		jp.loadDino("data/dinos.csv");
		ArrayList<Zone> zoneAL = jp.getZoneAL();
		ArrayList<Dinosaur> dinoAL = jp.getDinoAL();
		ArrayList<Dinosaur> printAL = null;
		String print = "";
		Zone searchZone = null;
		int i;
		
		for(i = 0; i < zoneAL.size(); i++)
		{
			if(zone.equals(zoneAL.get(i).getZoneCode()))
			{
				String ZL = zoneAL.get(i).getZoneName() + " Zone (" + zoneAL.get(i).getZoneCode() + ")";
				searchZone = zoneAL.get(i);
				zoneLabel.setText(ZL);
			}
		}
		
		HashMap<Zone, ArrayList<Dinosaur>> map = jp.createMap(zoneAL, dinoAL);
		
		if(map.containsKey(searchZone))
		{
			printAL = map.get(searchZone);
		}
		
		for(i = 0; i < printAL.size(); i++)
		{
			String carnIndi = "";
			if(printAL.get(i).getCarnIndi().equals("true"))
				carnIndi = "Herbavoir";
			
			else
				carnIndi = "Carnivoir";
			
			print = print + printAL.get(i).getDinoName() + " - " + printAL.get(i).getDinoType() + " - " + carnIndi + "\n";
		}
		
		dinoList.setText(print);
		int numDino = printAL.size();
		numDinosaurs.setText(Integer.toString(numDino));
		threatLevel.setText(searchZone.getThreatLevel());
		
	}
	
	/**
	 * Takes user back to the home view
	 * 
	 * @author iog693
	 * @throws IOException
	 */
	public void homeButton() throws IOException
	{
		Main.showMainView();
	}
	
	/**
	 * Adds dino to current zone and refreshes the page for the user to see
	 * 
	 * @author iog693
	 * @throws IOException
	 */
	public void addDino() throws IOException {
		
		String dName = addDinoName.getText();
		String dType = addDinoType.getText();
		ToggleGroup carn = new ToggleGroup();
		String carnIndi = null;
		yes.setToggleGroup(carn);
		no.setToggleGroup(carn);
		
		if(carn.getSelectedToggle() != null)
		{
			if(carn.getSelectedToggle().toString().equals("RadioButton[id=yes, styleClass=radio-button]'Yes'"))
				carnIndi = "false";
			
			else
				carnIndi = "true";
		}
		
		
		
		FileWriter fileWriter = new FileWriter("data/dinos.csv", true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		
		printWriter.println(dName + "," + dType + "," + carnIndi + ","+ zone);
			
		printWriter.close();
		
		addDinoName.clear();
		addDinoType.clear();
		succsessTextRelocate.setText("");
		succsessTextAdd.setText(dName + " succsessful added to zone " + zone);
		
		initialize();
	}
	
	/**
	 * Relocates a dinosaur in the current zone and refreshes the page
	 * 
	 * @author iog693
	 * @throws IOException
	 */
	public void relocate() throws IOException
	{
		Park jp = new Park("Jurassic Park", map);
		jp.loadDino("data/dinos.csv");
		String dName = relocateDinoName.getText();
		String zCode = relocateDinoZone.getText();
		ArrayList<Dinosaur> dinoAL = jp.getDinoAL();
		int i;
		
		for(i = 0; i < dinoAL.size(); i++)
		{
			if(dinoAL.get(i).getDinoName().equals(dName))
			{
				if(dinoAL.get(i).getDinoZone().equals(zone))
					dinoAL.get(i).setDinoZone(zCode);
			}
		}
		
		save(dinoAL);
		
		relocateDinoName.clear();
		relocateDinoZone.clear();
		succsessTextAdd.setText("");
		succsessTextRelocate.setText(dName + " succsessfuly relocated to zone " + zCode);
		
		initialize();
		
	}
	
	/**
	 * Saves the current dinoAL. Used after reloacting
	 * 
	 * @author iog693
	 * @param dinoAL after relocating a dino
	 */
	public void save(ArrayList<Dinosaur> dinoAL)
	{
		int i;
		Park jp = new Park("Jurassic Park", map);
		
		try
		{
			FileWriter fw = new FileWriter("data/dinos.csv");
			PrintWriter pw = new PrintWriter(fw);
			
			for(i = 0; i < dinoAL.size(); i++)
			{
				String dinoName = dinoAL.get(i).getDinoName();
				String dinoType = dinoAL.get(i).getDinoType();
				String dinoZone = dinoAL.get(i).getDinoZone();
				String carnIndi = dinoAL.get(i).getCarnIndi();
				
				pw.printf(dinoName + "," + dinoType + "," + carnIndi + "," + dinoZone + "\n");
			}
			pw.flush();
			pw.close();
			
		}
		catch(IOException e)
		{
			System.out.print("Error: Files did not save correctly");
		}
	}
}
