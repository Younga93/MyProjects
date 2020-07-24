package application;

//JavaFX Java GUI Tutorial - 8 - Embedding Layouts
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application
{
	Stage window;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		window = primaryStage;
		window.setTitle("8 - Embedding Layouts");
		
		HBox topMenu = new HBox();
		Button menuFile = new Button("File");
		Button menuEdit = new Button("Edit");
		Button menuView = new Button("View");
		topMenu.getChildren().addAll(menuFile, menuEdit, menuView);
		

		VBox leftMenu = new VBox();
		Button menu1 = new Button("What");
		Button menu2 = new Button("You've");
		Button menu3 = new Button("Done");
		leftMenu.getChildren().addAll(menu1, menu2, menu3);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);
		
		Scene scene = new Scene(borderPane, 300, 250);
		window.setScene(scene);
		window.show();
	}
}
