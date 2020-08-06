package application;

//JavaFX Java GUI Tutorial - 25-27. CSS Themes and Styles and Selectors
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
		window.setTitle("25-27. CSS Themes and Styles and Selectors");
		
		//GridPane with 10px padding around edge
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);

		//Name Label - constrains use (child, column, row)
		Label nameLabel = new Label("Username:");
			//inline styles
		//nameLabel.setStyle("-fx-text-fill: #E8E8E8");
			//style id
		nameLabel.setId("bold-label");
		GridPane.setConstraints(nameLabel, 0, 0);
		
		//Name Input
		TextField nameInput = new TextField("Young");
		GridPane.setConstraints(nameInput, 1, 0);

		//Password Label - constrains use (child, column, row)
		Label passLabel = new Label("Password:");
		GridPane.setConstraints(passLabel, 0, 1);
		
		//Password Input
		TextField passInput = new TextField("password");
		GridPane.setConstraints(passInput, 1, 1);
		
		//Login button
		Button loginButton = new Button("Log in");
		GridPane.setConstraints(loginButton, 1, 2);
		
		//Sign up
		Button signUpButton = new Button("Sign up");
			//style class
		signUpButton.getStyleClass().add("button-blue");
		GridPane.setConstraints(signUpButton, 1, 3);

//		//style...
//		loginButton.setOnAction(e -> {
//			setUserAgentStylesheet(STYLESHEET_CASPIAN);
//		});
		
		//Add everything to grid
		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, signUpButton);
		
		//Layout
		Scene scene = new Scene(grid, 300, 200);
		scene.getStylesheets().add("Viper.css");
		window.setScene(scene);
		window.show();
	}
}
