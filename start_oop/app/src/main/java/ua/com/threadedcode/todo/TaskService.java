package ua.com.threadedcode.todo;

import ua.com.threadedcode.lib.CrudProcessFactory;
import ua.com.threadedcode.lib.ICrudProcess;

import java.util.Collection;

public class TaskService {
    ICrudProcess<Task> crudProcess = CrudProcessFactory.getInstance().getCrudProcess();

    public void create(Task task) {
        crudProcess.create(task);
    }

    public void update(Task task) {
        crudProcess.update(task);
    }

    public void delete(String id) {
        crudProcess.delete(id);
    }

    public Collection<Task> read() {
        return crudProcess.read();
    }

    public Task read(String id) {
        return crudProcess.read(id);
    }
}
