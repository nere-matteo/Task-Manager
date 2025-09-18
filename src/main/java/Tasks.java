package main.java;

import java.util.ArrayList;
import java.util.Scanner;

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

    static void addTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What name would you like to give the task");
        String name = sc.nextLine();
        boolean status = false;
        Tasks newTask = new Tasks(name, status);
        taskList.add(newTask);
        sc.close();
    }
}
