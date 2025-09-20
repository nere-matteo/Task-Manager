import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tasks.loadTasksFromFile();
        
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running) {
            System.out.println("\nTask Manager Menu");
            System.out.println("1. Add task");
            System.out.println("2. List tasks");
            System.out.println("3. Change Status");
            System.err.println("4. Delete Task");
            System.out.println("5. Exit");
            System.err.println("Choose an option:  ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1: 
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter a description");
                    String description = sc.nextLine();
                    Tasks.addTask(name, description, LocalDate.now());
                    System.out.println("Task added.");
                    Tasks.saveTasksToFile(); 
                    break;
                case 2: 
                    System.out.println("Tasks:");
                    int i = 1;
                    for (Tasks t: Tasks.getTasks()) {
                        System.out.println(i++ + ". " + t.getName() + " Status: [" + t.getStatus().name() + "]" + " Description: " + t.getDescription() + ", " + t.getDate());
                    }
                    break;
                case 3:
                    int taskIndex = Tasks.selectTask(sc);
                    if (taskIndex != -1) {
                        Tasks.checkTask(taskIndex);
                        Tasks.saveTasksToFile(); 
                    }
                    break;
                case 4: 
                    int deleteIndex = Tasks.selectTask(sc);
                    if(deleteIndex != -1) {
                        Tasks.deleteTask(deleteIndex);
                        Tasks.saveTasksToFile(); 
                    }
                    break;
                case 5: 
                    running = false;
                    break;
                default: 
                    System.out.println("Invalid option");
            }
        }
        sc.close();
    }
}

