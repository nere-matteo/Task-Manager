import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Tasks {
	private String name; 
	private String description;
    private Status status;
    private LocalDate date;

    enum Status {
        Todo,
        Done,
        InProgress,
    }

    private static ArrayList<Tasks> taskList = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status; 
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public Tasks(String name, String description, LocalDate date) {
		this.name = name;
        this.description = description;
        this.status = Status.Todo;
        this.date = date;
	}

    static void addTask(String name, String description, LocalDate date) {
        Tasks newTask = new Tasks(name, description, LocalDate.now());
        taskList.add(newTask);
    }

	public static ArrayList<Tasks> getTasks() {
		return taskList;
	}

    public static void checkTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            Status selectedStatus = selectStatus();
            taskList.get(index).setStatus(selectedStatus);
            System.out.println("Task checked");
        } else {
            System.out.println("Invalid task number");
        }
    }

    public static Status selectStatus() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select a status");
        for (Status s : Status.values()) {
            System.out.println("- " + s.name());
        }

        String answer = sc.nextLine();

        try {
            return Status.valueOf(answer);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid choice");
            return Status.Todo;
        }
    }

    public static void deleteTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.remove(index);
            System.out.println("Task deleted");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static int selectTask(Scanner sc) {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available");
            return -1;
        }

        System.out.println("Tasks:");
        for (int i = 0; i < taskList.size(); i++) {
            Tasks t = taskList.get(i);
            System.out.println((i + 1) + ". " + t.getName() + " [" + t.getStatus().name() + "]");
        }

        System.out.println("Enter task number: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice >= 1 && choice <= taskList.size()) {
            return choice -1;
        } else {
            System.out.println("Invalid task number");
            return -1;
        }
    }
}


