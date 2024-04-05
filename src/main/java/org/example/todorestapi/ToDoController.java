package org.example.todorestapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController

public class ToDoController {


    private ToDoService toDoService;
    private List<ToDo> listOfTodos ;
    public ToDoController(@Qualifier("FakeToDoService") ToDoService toDoService){
        this.toDoService = toDoService;
        listOfTodos = new ArrayList<>();
        listOfTodos.add(new ToDo(1,"Backend in Springboot",true));
        listOfTodos.add(new ToDo(2,"Backend in NodeJS",true));
        listOfTodos.add(new ToDo(3,"Backend in RubyOnRails",false));
        listOfTodos.add(new ToDo(4,"Backend in Django",false));
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
    @GetMapping("/getTodoById/{todoId}")
    public ResponseEntity<ToDo> getTodoById(@PathVariable long todoId){
        for(ToDo t : listOfTodos){
            if(t.getId()==todoId){
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.notFound().build();
    }
    //@GetMapping("/todosFilter")

//    public ResponseEntity<List<ToDo>> getTodosByFilter(@RequestParam(required = false,defaultValue = "true") boolean isComplete){
//        System.out.println("incoming request param "+ isComplete +" "+ toDoService.doSomething());
//        return ResponseEntity.ok(listOfTodos);
//    }

    @GetMapping("/todosNew")
    public ResponseEntity<List<ToDo>> getTodosByFilter2(@RequestParam(required = false, defaultValue = "true") boolean isComplete) {
        List<ToDo> filteredTodos = new ArrayList<>();
        System.out.println("incoming request param "+ isComplete +" "+ toDoService.doSomething());
        for (ToDo todo : listOfTodos) {
            if (isComplete && todo.isCompleted()) {
                filteredTodos.add(todo);
            } else if (!isComplete && !todo.isCompleted()) {
                filteredTodos.add(todo);
            }
        }
        return ResponseEntity.ok(filteredTodos);
    }



}
