package org.example.todorestapi;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("FakeToDoService")


public class FakeToDoService implements ToDoService{
    @Override
    public String doSomething() {
        return "Something";
    }
}
