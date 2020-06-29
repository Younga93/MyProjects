using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ToDoList
{
    class Program
    {
        static void Main(string[] args)
        {
            string userInput;
            Task task;
            do
            {
                Console.WriteLine("Select below option");
                Console.WriteLine("  1 : add a task");
                Console.WriteLine("  2 : list tasks");
                Console.WriteLine("999 : exit program");
                userInput = Console.ReadLine();

                if (userInput == "1")
                {
                    task = AddTask();

                    Console.WriteLine("Success to add");
                    Console.WriteLine(task.ToString());
                }
                else if (userInput == "2")
                {

                }
                else if (userInput == "999")
                {
                    Console.WriteLine("Good job today. Take care!");
                }
                else
                {
                    Console.WriteLine("Invalid option is entered.");
                }
            } while (userInput == "999");
        }


        static Task AddTask()
        {
            string name;
            string description;
            //DateTime dueDate;
            //DateTime startDate = DateTime.Today;
            Priority priority;

            Console.Write("Enter the name of task : ");
            name = Console.ReadLine();

            Console.Write($"Describe {name} : ");
            description = Console.ReadLine();

            //Console.Write($"When is the due for {name}? (mm/dd/yyyy) : ");
            //dueDate = DateTime.Parse(Console.ReadLine());

            Console.Write("choose the priority (1: High/ 2: Medium/ 3: Low) : ");
            switch (Console.ReadLine())
            {
                case "1":
                    priority = Priority.High;
                    break;
                case "2":
                    priority = Priority.Medium;
                    break;
                case "3":
                    priority = Priority.High;
                    break;
                default:
                    priority = Priority.Else;
                    break;
            }

            //return new Task(name, description, startDate, dueDate, priority);
            return new Task(name, description, priority);
        }
    }
}
