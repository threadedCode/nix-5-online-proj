package ua.com.threadedcode.todo;

import ua.com.threadedcode.lib.BaseEntity;

public class Task extends BaseEntity {
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.getId() +
                ": " + title + "\n" +
                description + "\n" +
                "================";
    }
}
