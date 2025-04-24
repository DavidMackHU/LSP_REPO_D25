package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * Represents a Task with a name, priority, and status.
 */
class Task {
    private String name;
    private int priority;
    private String status;

    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}

/**
 * Exception thrown when a task with the same name already exists.
 */
class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String message) {
        super(message);
    }
}

/**
 * Exception thrown when a task is not found by name.
 */
class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}

/**
 * Manages a collection of tasks by adding, retrieving, updating status, and printing.
 */
public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task to the manager.
     * 
     * @param name     unique task name
     * @param priority task priority
     * @param status   initial task status
     * @throws DuplicateTaskException if a task with the same name exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by name.
     * 
     * @param name task name
     * @return the corresponding Task
     * @throws TaskNotFoundException if task doesn't exist
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        if (!tasks.containsKey(name)) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return tasks.get(name);
    }

    /**
     * Updates the status of an existing task.
     * 
     * @param name   task name
     * @param status new status
     * @throws TaskNotFoundException if task doesn't exist
     */
    public void updateStatus(String name, String status) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(status);
    }

    /**
     * Prints tasks grouped by their status.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        Map<String, List<Task>> grouped = new TreeMap<>();
        for (Task task : tasks.values()) {
            grouped.computeIfAbsent(task.getStatus(), k -> new ArrayList<>()).add(task);
        }
        for (String status : List.of("TODO", "IN_PROGRESS", "DONE")) {
            System.out.println(status + ":");
            List<Task> list = grouped.getOrDefault(status, new ArrayList<>());
            for (Task task : list) {
                System.out.println("  " + task);
            }
        }
    }
}

/**
 * Driver class for testing the TaskManager system.
 */
class Driver {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        try {
            manager.addTask("Fix Bug #204", 1, "TODO");
            manager.addTask("Write Docs", 3, "TODO");
            manager.addTask("Setup CI/CD", 2, "IN_PROGRESS");

            // Duplicate task
            manager.addTask("Fix Bug #204", 4, "DONE");
        } catch (DuplicateTaskException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Task t = manager.getTaskByName("Write Docs");
            System.out.println("Retrieved: " + t);
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            manager.updateStatus("Write Docs", "DONE");
            manager.updateStatus("Nonexistent Task", "IN_PROGRESS");
        } catch (TaskNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Print all tasks grouped by status
        manager.printTasksGroupedByStatus();
    }
}
