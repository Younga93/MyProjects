using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ToDoList
{
    enum Priority
    {
        Else,       // 0
        High,       // 1
        Medium,     // 2
        Low,        // 3
    }
    class Task
    {
        //fields
        private static int currentId = 1;

        //properties
        public int TaskId { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public DateTime StartDate { get; set; }
        public DateTime DueDate { get; set; }
        public Priority Priority { get; set; }

        //constructors
        public Task(string name, string description, DateTime startDate, DateTime dueDate, Priority priority)
        {
            TaskId = currentId;
            currentId++;
            Name = name;
            Description = description;
            StartDate = startDate;
            DueDate = dueDate;
            Priority = priority;
        }
        public Task(string name, string description, Priority priority)
        {
            TaskId = currentId;
            currentId++;
            Name = name;
            Description = description;
            StartDate = DateTime.Today;
            DueDate = DateTime.Today;
            Priority = priority;
        }
        //methods
        public override string ToString()
        {
            return $"currentId : {currentId}\nTaskId: {TaskId}\nName: {Name}\nDescription: {Description}\nStartDate: {StartDate}\nDueDate: {DueDate}\nPriority: {Priority}";
        }
    }
}
