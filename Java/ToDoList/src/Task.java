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
	protected LocalDate created; 
	protected Priority priority;
	
	protected DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	//constructor
	public Task(String name,String description, Priority priority)
	{		
		id = taskId++;
		this.name = name;
		this.description = description;
		created = LocalDate.now();;
		this.priority = priority;
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
	//created :read-only
	public String getCreated()
	{
		return created.format(dateFormat);
	}
	//priority
	public Priority getPriority()
	{
		return priority;
	}
	public void setDescription(Priority priority)
	{
		this.priority = priority;
	}
	
	@Override
	public String toString()
	{
		//String s = String.format("$%.2f", salary);
		String s = String.format("#%d - %s - %s", id, priority, name);
		return s;
	}
}
