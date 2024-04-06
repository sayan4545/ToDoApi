package org.example.todorestapi;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Primary
@Service("FakeToDoService")



public class FakeToDoService implements ToDoService{
    @TimeMonitor
    @Override
    public String doSomething() {
//        for(long i=0;i<1000000000;i++){
//        }
        return "Something";

    }
}
