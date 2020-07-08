
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//driver class
public class ToDoList {

	static Scanner scanner = new Scanner(System.in);
	static List<Task> tasks = new ArrayList<>();
	
	public static void main(String[] args) 
	{
		AddInitialData();
		
		String userInput;

		while(true)
		{
			System.out.println("1. Display all tasks");
			System.out.println("2. Display high priority tasks");
			System.out.println("3. Display medium priority tasks");
			System.out.println("4. Display low priority taks");
			System.out.println("999. Terminate application");
			
			userInput = scanner.next();
			
			switch (userInput)
			{
				case "1":
					DisplayTasks();
					PressAnyKeyToContinue();
					break;
				case "2":
					DisplayTasks(Priority.HIGH);
					PressAnyKeyToContinue();
					break;
				case "3":
					DisplayTasks(Priority.MEDIUM);
					PressAnyKeyToContinue();
					break;
				case "4":
					DisplayTasks(Priority.LOW);
					PressAnyKeyToContinue();
					break;
				case "999":
					System.out.println("***Thank you***");
					System.exit(0);
				default:
					System.out.println("***Invalid option has entered.***");
					PressAnyKeyToContinue();
					break;
			}
		}
		
	}
	
	public static void AddInitialData()
	{
		tasks.add(new Task("Product team meeting","about AAA", Priority.MEDIUM));
		tasks.add(new Task("Development team meeting","welcoming new employees", Priority.MEDIUM));
		tasks.add(new Task("Job interview","Camo Mile, Centennial college Software Engineering", Priority.HIGH));
		tasks.add(new Task("Laundry","bedding", Priority.LOW));
		tasks.add(new TimeLimitTask("Pay rent fee","$1200.00", Priority.HIGH, "31-07-2020"));
	}
	
	//Display all tasks
	public static void DisplayTasks()
	{
		for(Task t : tasks)
		{
			System.out.println(t.toString());
		}
	}
	
	//Overloaded: Display only selected priority tasks
	public static void DisplayTasks(Priority p)
	{
		for(Task t : tasks)
		{
			if(t.priority == p)
			{
				System.out.println(t.toString());
			}
		}
	}
	
	public static void PressAnyKeyToContinue()
	{
		System.out.println("To go back main menu, press any key to continue.");
		try
		{
			System.in.read();
		}  
		catch(Exception ex)
		{}
	}
}
