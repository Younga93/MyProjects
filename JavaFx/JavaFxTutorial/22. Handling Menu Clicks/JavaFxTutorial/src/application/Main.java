package application;

//JavaFX Java GUI Tutorial - 22. Handling Menu Clicks
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
		window.setTitle("22. Handling Menu Clicks");
		
		//File menu
		Menu fileMenu = new Menu("File");
		
		//Menu items
		MenuItem newFile = new MenuItem("New...");
		newFile.setOnAction(e -> System.out.println("Create a new file..."));
		fileMenu.getItems().add(newFile);
		
		fileMenu.getItems().add(new MenuItem("Open..."));
		fileMenu.getItems().add(new MenuItem("Save..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Settings..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Exit..."));
		
		//Edit menu
		Menu editMenu = new Menu("_Edit");  //E is gonna be a shorcut
		editMenu.getItems().add(new MenuItem("Cut"));
		editMenu.getItems().add(new MenuItem("Copy"));

		MenuItem paste = new MenuItem("Paste");
		paste.setOnAction(e -> System.out.println("Pasting some crap"));
		paste.setDisable(true);	//disable paste menu item.
		editMenu.getItems().add(paste);
		
		//Main menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, editMenu);
		
		//Layout
		layout = new BorderPane();
		layout.setTop(menuBar);
		Scene scene = new Scene(layout, 400, 300);
		window.setScene(scene);
		window.show();
	}
}
