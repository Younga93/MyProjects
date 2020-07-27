package application;

//JavaFX Java GUI Tutorial - 14 - ComboBox
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application
{
	Stage window;
	Scene scene;
	Button button;
	ComboBox<String> comboBox;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		window = primaryStage;
		window.setTitle("14 - ComboBox");
		
		//Button
		button = new Button("Submit");
		
		comboBox = new ComboBox<>();
		comboBox.getItems().addAll(
				"Good will Hunting",
				"St. Vincent",
				"Blackhat"
		);
		
		comboBox.setPromptText("What is your favorite movie?");
		
		comboBox.setEditable(true);
		
		button.setOnAction(e -> printMovie());
		
		comboBox.setOnAction(e -> System.out.println("User selected: " + comboBox.getValue() ) );
		
		//Layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(comboBox, button);
		
		scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}
	
	//print out a movie
	private void printMovie()
	{
		System.out.println(comboBox.getValue());
	}
}
