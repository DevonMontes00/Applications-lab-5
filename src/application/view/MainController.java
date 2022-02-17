package application.view;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MainController {
	@FXML
	ImageView logo;
	
	@FXML
	Button zoneB;
	
	@FXML
	Button zoneD;
	
	@FXML
	Button zoneG;
	
	@FXML
	Button zoneR;
	
	@FXML
	Button zoneTR;
	
	@FXML
	Button zoneTY;
	
	@FXML
	Button zoneX;
	
	/**
	 * Shows zoneview but sends a string of "B"
	 * 
	 * @author iog693
	 * @param e
	 * @throws IOException
	 */
	public void showZoneB (ActionEvent e) throws IOException
	{
		Main.showZoneView("B");
	}
	
	/**
	 * Shows zoneview but sends a string of "D"
	 * 
	 * @author iog693
	 * @param e
	 * @throws IOException
	 */
	public void showZoneD (ActionEvent e) throws IOException
	{
		Main.showZoneView("D");
	}
	
	/**
	 * Shows zoneview but sends a string of "G"
	 * 
	 * @author iog693
	 * @param e
	 * @throws IOException
	 */
	public void showZoneG (ActionEvent e) throws IOException
	{
		Main.showZoneView("G");
	}
	
	/**
	 * Shows zoneview but sends a string of "R"
	 * 
	 * @author iog693
	 * @param e
	 * @throws IOException
	 */
	public void showZoneR (ActionEvent e) throws IOException
	{
		Main.showZoneView("R");
	}
	
	/**
	 * Shows zoneview but sends a string of "TR"
	 * 
	 * @author iog693
	 * @param e
	 * @throws IOException
	 */
	public void showZoneTR (ActionEvent e) throws IOException
	{
		Main.showZoneView("TR");
	}
	
	/**
	 * Shows zoneview but sends a string of "TY"
	 * 
	 * @author iog693
	 * @param e
	 * @throws IOException
	 */
	public void showZoneTY (ActionEvent e) throws IOException
	{
		Main.showZoneView("TY");
	}
	
	/**
	 * Shows zoneview but sends a string of "X"
	 * 
	 * @author iog693
	 * @param e
	 * @throws IOException
	 */
	public void showZoneX (ActionEvent e) throws IOException
	{
		Main.showZoneView("X");
	}
}
