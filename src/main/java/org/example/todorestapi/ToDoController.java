package org.example.todorestapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ToDoController {
    private List<ToDo> listOfTodos ;

    public ToDoController(){
        listOfTodos = new ArrayList<>();
        listOfTodos.add(new ToDo(1,"Backend in Springboot",true));
    }
    @GetMapping("/getTodos")
    public List<ToDo> getTodos(){
        return listOfTodos;
    }
    @PostMapping("/createTodos")
    public ToDo createTodos(@RequestBody ToDo newTodo){
        listOfTodos.add(newTodo);
        return newTodo;
    }

}
