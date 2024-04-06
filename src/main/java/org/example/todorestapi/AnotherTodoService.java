package org.example.todorestapi;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("AnotherTodoService")

public class AnotherTodoService implements ToDoService{
    @Override
    public String doSomething() {
        return "something from Another toDoService";
    }
}
