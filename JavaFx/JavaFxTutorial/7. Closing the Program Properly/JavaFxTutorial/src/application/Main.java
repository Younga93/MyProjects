package application;

//JavaFX Java GUI Tutorial - 7 - Closing the Program Properly
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application
{
	Stage window;
	Button button;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		window = primaryStage;
		window.setTitle("7 - Closing the Program Properly");
		
		//Whenever the window is closed
		window.setOnCloseRequest(e -> 
		{
			e.consume();
			closeProgram();
		}
		);
		
		button = new Button("Close Program");
		
		//only when this button is clicked
		button.setOnAction(e -> closeProgram());
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}
	
	private void closeProgram() 
	{
		Boolean answer = ConfirmBox.display("Sure??", "Sure you want to exit?");
		if(answer)
		{
			window.close();
		}
//		System.out.println("File is saved!");
//		window.close();
	}
}
