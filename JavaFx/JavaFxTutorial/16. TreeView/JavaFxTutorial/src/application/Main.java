package application;

//JavaFX Java GUI Tutorial - 16 - TreeView
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application
{
	Stage window;
	TreeView<String> tree;
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		window = primaryStage;
		window.setTitle("16 - TreeView");
		
		TreeItem<String> root, young, jin;
		
		//Root
		root = new TreeItem<>();
		root.setExpanded(true);
		
		//Young
		young = makeBranch("Young", root);
		makeBranch("Scarborough", young);
		makeBranch("Toronto", young);
		makeBranch("Canada", young);
		
		//Jin
		jin = makeBranch("Jin", root);
		makeBranch("Moseulpo", jin);
		makeBranch("Jeju", jin);
		makeBranch("South Korea", jin);
		
		//Create tree
		tree = new TreeView<>(root);
		tree.setShowRoot(false); //when this is commented out, there is an empty item at the top
		tree.getSelectionModel().selectedItemProperty()
				.addListener((v, oldValue, newValue) -> {
					if(newValue != null)
						System.out.println(newValue.getValue());
				});
		
		//Layout
		StackPane layout = new StackPane();
		layout.getChildren().add(tree);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}
	
	//Create branches
	public TreeItem<String> makeBranch(String title, TreeItem<String> parent)
	{
		TreeItem<String> item = new TreeItem<>(title);
		item.setExpanded(true);
		parent.getChildren().add(item);
		
		return item;
	}
	
}
