import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running) {
            System.out.println("\nTask Manager Menu");
            System.out.println("1. Add task");
            System.out.println("2. List tasks");
            System.out.println("3. Check tasks");
            System.err.println("4. Delete Task");
            System.out.println("5. Exit");
            System.err.println("Choose an option:  ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1: 
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();
                    Tasks.addTask(name);
                    System.out.println("Task added.");
                    break;
                case 2: 
                    System.out.println("Tasks:");
                    int i = 1;
                    for (Tasks t: Tasks.getTasks()) {
                        System.out.println(i++ + ". " + t.getName() + " [" + (t.getStatus() ? "Checked" : "Unchecked") + "]");
                    }
                    break;
                case 3:
                    int k = 1;
                    for (Tasks t: Tasks.getTasks()) {
                        System.out.println(k++ + ". " + t.getName() + " [" + (t.getStatus() ? "Checked" : "Unchecked") + "]");
                    }
                    System.out.println(" Enter task number to check");
                    int checkNum = sc.nextInt();
                    sc.nextLine();
                    Tasks.checkTask(checkNum - 1);
                    break;
                case 4: 
                    int j = 1;
                    for (Tasks t: Tasks.getTasks()) {
                        System.out.println(j++ + ". " + t.getName() + " [" + (t.getStatus() ? "Checked" : "Unchecked") + "]");
                    }
                    System.out.println("Enter task number to delete: ");
                    int delNum = sc.nextInt();
                    sc.nextLine();
                    Tasks.deleteTask(delNum - 1);
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

