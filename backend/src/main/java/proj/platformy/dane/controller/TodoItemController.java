package proj.platformy.dane.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proj.platformy.dane.entity.sql.Todo;
import proj.platformy.dane.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoItemController {
  @Autowired
  private TodoService todoService;

  @PostMapping("/add")
  private Todo addTodo(@RequestBody Todo todoItem) {
    return todoService.save(todoItem);
  }

  @GetMapping("{id}")
  private Todo getTodo(@PathVariable int id) {
    return todoService.getById(id);
  }

  @GetMapping
  private List<Todo> getAllTodos() {
    return todoService.getAll();
  }

  @DeleteMapping("{id}")
  private void deleteTodo(@PathVariable int id) {
    todoService.deleteTodoById(id);
  }

  @PutMapping()
  private Todo updateTodo(@RequestBody Todo todoItem) {
    return todoService.update(todoItem);
  }

}
