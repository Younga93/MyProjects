import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

enum Priority
{
	LOW,
	MEDIUM,
	HIGH
}

public class Task //(need to be changed to abstract!!!!!!)
{	
	//Fields
	static int taskId = 1;
	protected int id;
	protected String name;
	protected String description;
	protected Priority priority;
	protected LocalDate dueDate = null;
	protected LocalDate created; 
	
	protected DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	//constructors (with DueDate, withoutDueDate)
	//without DueDate
	public Task(String name,String description, Priority priority)
	{		
		id = taskId++;
		this.name = name;
		this.description = description;
		this.priority = priority;
		created = LocalDate.now();;
	}
	//with DueDate
	public Task(String name,String description, Priority priority, String dueDateString)
	{		
		id = taskId++;
		this.name = name;
		this.description = description;
		this.priority = priority;
		created = LocalDate.now();;
		setDueDate(dueDateString);
	}
	
	//Getter and Setter
	//name
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	//description
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	//priority
	public Priority getPriority()
	{
		return priority;
	}
	public void setPriority(Priority priority)
	{
		this.priority = priority;
	}
	//created: read-only
	public String getCreated()
	{
		return created.format(dateFormat);
	}
	//dueDate: get String type and formatting as LocalDate type.
	public LocalDate getDueDate()
	{
		return dueDate;
	}
	public void setDueDate(String userInput)
	{
		if(userInput == "No" || userInput == "NO" || userInput == "no"){
			this.dueDate = null;
		}
		else{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate dueDate = LocalDate.parse(userInput, formatter);
			
			this.dueDate = dueDate;
		}
	}
	
	@Override
	public String toString()
	{
		//String s = String.format("$%.2f", salary);
		String s = String.format("#%d - %s - %s", id, priority, name);
		return s;
	}
}
