package application;

//JavaFX Java GUI Tutorial - 21. Making Menus
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application
{
	Stage window;
	BorderPane layout;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		window = primaryStage;
		window.setTitle("21. Making Menus");
		
		//File menu
		Menu fileMenu = new Menu("File");
		
		//Menu items
		fileMenu.getItems().add(new MenuItem("New Project..."));
		fileMenu.getItems().add(new MenuItem("New Module..."));
		fileMenu.getItems().add(new MenuItem("Import Project..."));
		
		//Main menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu);
		
		//Layout
		layout = new BorderPane();
		layout.setTop(menuBar);
		Scene scene = new Scene(layout, 400, 300);
		window.setScene(scene);
		window.show();
	}
}
