package application;

import java.io.IOException;

import application.view.ZoneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{

	private static Stage primaryStage;
	private static AnchorPane mainLayout;
	
	/**
	 * Starts the application
	 * 
	 * @author iog693
	 * @param Primary stage for the application
	 */
	public void start(Stage primaryStage) throws IOException 
	{
		Main.primaryStage = primaryStage;
		Main.primaryStage.setTitle("Jurassic Park App");
		showMainView();
	}
	
	/**
	 * Shows the main view of the app
	 * 
	 * @author iog693
	 * @throws IOException
	 */
	public static void showMainView() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Main.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Shows the zone view of the app
	 * 
	 * @author iog693
	 * @param String of zone chosen
	 * @throws IOException
	 */
	public static void showZoneView(String zone) throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Zone.fxml"));
		ZoneController cc = new ZoneController(zone);
		loader.setController(cc);
		AnchorPane zoneLayout = loader.load();
		mainLayout.getChildren().setAll(zoneLayout);
	}
	
	/**
	 * Main function
	 * 
	 * @author iog693
	 * @param args
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}
	
}
