import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TimeLimitTask extends Task
{

	protected LocalDate dueDate = null;
	
	//constructors (with DueDate, withoutDueDate
	public TimeLimitTask(String name, String description, Priority priority) 
	{
		super(name, description, priority);
	}
	public TimeLimitTask(String name, String description, Priority priority, String dueDate) 
	{
		super(name, description, priority);
		setDueDate(dueDate); 
	}

	//Getter dueDate
	public String getDueDate()
	{
		if(dueDate == null)
		{
			return "not defined";
		}
		else
		{
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			return dueDate.format(dateFormat);
		}
	}
	public void setDueDate(String dueDate)
	{
		this.dueDate = LocalDate.parse(dueDate, dateFormat); //"dd-mm-yyyy"
	}
	
	@Override
	public String toString()
	{
		//String s = String.format("$%.2f", salary);
		String s = String.format("#%d - %s (Due: %s) - %s", id, priority, getDueDate(), name);
		return s;
	}
}
