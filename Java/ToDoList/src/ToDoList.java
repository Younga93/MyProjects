
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
			System.out.println("5. Add a new task");
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
				case "5":
					AddTask();
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
	
	//For initial tasks
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
	
	//Add a new task
	public static void AddTask()
	{
		System.out.println("----------------------------------");
		System.out.println("1. Without Due 2. With Due");
		System.out.print("What kind of task will you add?");
		
		String userInput = scanner.next();
		
		Task t;
		
		switch (userInput)
		{
			case "1":
				t = new Task(PromptString("Name of task"), PromptString("Description"), PromptPriority());
				tasks.add(t);
				System.out.println(t.toString() + " is added.");
				break;
			case "2":
				t = new TimeLimitTask(PromptString("Name of task"), PromptString("Description"), PromptPriority());
				((TimeLimitTask) t).setDueDate(PromptString("When is the due date? (dd-mm-yyyy) "));
				tasks.add(t);
				System.out.println(t.toString() + " is added.");
				break;
			default:
				System.out.println("***Invalid option has entered.***");
				PressAnyKeyToContinue();
				break;
		}
	}
	
	//Prompting methods
	public static String PromptString(String value)
	{
		System.out.print(value + ": ");
		
		String userInput = scanner.next();
		
		return userInput;
	}
	public static int PromptInt(String value)
	{
		boolean checker = true;
		String userInput;
		int result = 0;
		do
		{
			checker = false;

			System.out.print(value + ": ");
			
			userInput = scanner.next();
			try
			{
				result = Integer.parseInt(userInput);
			}catch(Exception ex)
			{
				checker = true;
				System.out.println("Please enter an integer.");
			}
		}while(checker);
		
		return result;
	}
	public static Priority PromptPriority()
	{
		boolean checker;
		String userInput;
		Priority result = null;
		do
		{
			checker = false;

			System.out.print("Choose priority: 1. High 2. Medium 3. Low");
			
			userInput = scanner.next();
			switch(userInput)
			{
				case "1":
					result = Priority.HIGH;
					break;
				case "2":
					result = Priority.MEDIUM;
					break;
				case "3":
					result = Priority.LOW;
					break;
				default:
					checker = true;
					break;
			}
		}while(checker);
		
		return result;
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
