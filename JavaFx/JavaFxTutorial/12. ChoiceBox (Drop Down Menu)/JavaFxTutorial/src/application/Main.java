package application;

//JavaFX Java GUI Tutorial - 12 - ChoiceBox(Drop Down Menu)
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application
{
	Stage window;
	Scene scene;
	Button button;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		window = primaryStage;
		window.setTitle("12 - ChoiceBox(Drop Down Menu)");
		
		//Button
		button = new Button("Click");
		
		ChoiceBox<String> choiceBox = new ChoiceBox</*String*/>();
		
		//getItems returns the ObservableList object which you can add items to
		choiceBox.getItems().add("Apples");
		choiceBox.getItems().add("Bananas");
		choiceBox.getItems().addAll("Bacon", "Ham", "Meatballs");
		
		//set a default value;
		choiceBox.setValue("Apples"); //this value should match to the value already exists.
		
		button.setOnAction(e-> getChoice(choiceBox));
		
		//Layout
		VBox layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(choiceBox, button);
		
		scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}
	
	//To get the value of the selected item
	private void getChoice(ChoiceBox<String> choiceBox)
	{
		String food = choiceBox.getValue();
		System.out.println(food);
	}
}
