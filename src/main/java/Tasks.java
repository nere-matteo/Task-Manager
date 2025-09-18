

import java.util.ArrayList;

public class Tasks {
	private String name; 
	private boolean status;

    private static ArrayList<Tasks> taskList = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean newStatus) {
		this.status = newStatus;
	}

	public Tasks(String name, boolean status) {
		this.name = name;
		this.status = status;
	}

    static void addTask(String name) {
        boolean status = false;
        Tasks newTask = new Tasks(name, status);
        taskList.add(newTask);
    }

	public static ArrayList<Tasks> getTasks() {
		return taskList;
	}

    public static void checkTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.get(index).setStatus(true);
            System.out.println("Task checked");
        } else {
            System.out.println("Invalid task number");
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
}


