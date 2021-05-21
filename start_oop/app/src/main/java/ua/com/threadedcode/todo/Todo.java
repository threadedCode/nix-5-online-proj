package ua.com.threadedcode.todo;

import java.util.Collection;

public class Todo {
    TaskService taskService = new TaskService();
    Collection<Task> list;

    public void deleteTask(String title) {
        String taskId = "";
        for (Task task : list) {
            if (task.getTitle().equals(title)) {
                taskId = task.getId();
            }
        }
        taskService.delete(taskId);
    }

    public void updateTaskDescription(String title, String newDescription) {
        for (Task task : list) {
            if (task.getTitle().equals(title)) {
                task.setDescription(newDescription);
                taskService.update(task);
            }
        }
    }

    public void updateTaskTitle(String title, String newTitle) {
        for (Task task : list) {
            if (task.getTitle().equals(title)) {
                task.setTitle(newTitle);
                taskService.update(task);
            }
        }
    }

    public void readTask() {
        list = taskService.read();
        list.forEach(System.out::println);
    }

    public void addTask(String title, String description) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        taskService.create(task);

    }
}
