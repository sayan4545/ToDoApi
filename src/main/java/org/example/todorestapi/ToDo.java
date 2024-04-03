package org.example.todorestapi;

public class ToDo {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    private int id;
    private String description;
    private boolean isCompleted;

    public ToDo(int id, String description, boolean isCompleted) {
        this.id = id;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
