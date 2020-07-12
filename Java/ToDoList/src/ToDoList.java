import java.time.LocalDate;
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
			System.out.println("1. Display all tasks in order to priority");
			System.out.println("2. Add a new task");
			System.out.println("3. Edit a task");
			System.out.println("4. Delete a task");
			System.out.println("999. Terminate application");
			
			userInput = scanner.next();
			
			switch (userInput)
			{
				case "1":
					//from high priority to low priority
					DisplayTasks(Priority.HIGH);
					DisplayTasks(Priority.MEDIUM);
					DisplayTasks(Priority.LOW);
					PressAnyKeyToContinue();
					break;
				case "2":
					//Add a new task
					AddTask();
					PressAnyKeyToContinue();
					break;
				case "3":
					//Edit a new task
					DisplayTasks();
					EditTask(ChooseTask());
					//DisplayTasks(Priority.MEDIUM);
					PressAnyKeyToContinue();
					break;
				case "4":
					//Delete a task
					DisplayTasks();					
					tasks.remove(ChooseTask());
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
		tasks.add(new Task("Pay rent fee","$1200.00", Priority.HIGH, "31-07-2020"));
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
		Task t = new Task(PromptString("Name of task"), PromptString("Description"), PromptPriority());
		
		tasks.add(t);
		System.out.println(t.toString() + " is added.");

	}
	//
	public static Task ChooseTask(){
		int userInput = PromptInt("Choose the id of task");
		Task task = null;
		for(Task t : tasks)
		{
			if(t.id == userInput)
			{
				task = t;
			}
		}
		return task;
	}
	//Edit a task
	public static void EditTask(Task task){
		task.setName(PromptString("Rename the task"));
		task.setDescription(PromptString("Redescribe the task"));
		task.setPriority(PromptPriority());
		boolean checker = true;
		while(checker)
		{
			try{
				task.setDueDate(PromptString("Reset the due date (dd-MM-yyyy)\nEnter \"No\" to delete due date"));
				checker = false;
			}
			catch(Exception ex)
			{
				System.out.println("Invalid value has entered.");
			}
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
		boolean checker = true;
		int userInput;
		Priority result = null;
		do
		{
			System.out.println("Choose priority: 1. High 2. Medium 3. Low");
			
			try
			{
				userInput = Integer.parseInt(scanner.next());

				switch(userInput)
				{
					case 1:
						result = Priority.HIGH;
						checker = false;
						break;
					case 2:
						result = Priority.MEDIUM;
						checker = false;
						break;
					case 3:
						result = Priority.LOW;
						checker = false;
						break;
					default:
						System.out.println("Please choose proper Priority.");
						break;
				}
			}
			catch(NumberFormatException ex)
			{
				System.out.println("Invalid value has entered.");
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
