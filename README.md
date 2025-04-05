# basic-java-projects
 package test;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

    private String description;
    private boolean completed;

    public TodoList(String task) {
        this.description = task;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }
}

class Task {
    private ArrayList<TodoList> tasks;

    public Task() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new TodoList(description));
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid index. Please enter a number between 1 and " + tasks.size());
        }
    }

    public void fetchAll() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available. Please add a task.");
        } else {
            System.out.println("Your Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                TodoList task = tasks.get(i);
                System.out.println((i + 1) + ". " + task.getDescription() + " - " + (task.isCompleted() ? "Completed" : "Pending"));
            }
        }
    }

    public void markAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setCompleted(true);
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid index. Please enter a valid task number.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task taskManager = new Task();

        while (true) {
            try {
                System.out.println("===== WELCOME TO TO-DO LIST =====");
                System.out.println("1. Add Task");
                System.out.println("2. Remove Task");
                System.out.println("3. Mark Task as Completed");
                System.out.println("4. Show All Tasks");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter the Task: ");
                        String taskDescription = sc.nextLine();
                        taskManager.addTask(taskDescription);
                        System.out.println("Task added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter task number to remove: ");
                        int removeIndex = sc.nextInt() - 1;
                        taskManager.removeTask(removeIndex);
                        break;

                    case 3:
                        System.out.print("Enter task number to mark as completed: ");
                        int completeIndex = sc.nextInt() - 1;
                        taskManager.markAsCompleted(completeIndex);
                        break;

                    case 4:
                        taskManager.fetchAll();
                        break;

                    case 5:
                        System.out.println("Exiting... Thank you for using the To-Do List app!");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Please enter a valid option.");
                }
            } catch (Exception e) {
                System.err.println("Invalid input. Please enter a number.");
                sc.next(); // Clear the invalid input
            }
        }
    }
}
