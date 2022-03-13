package proj.platformy.dane.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.platformy.dane.entity.Todo;
import proj.platformy.dane.repository.TodoRepository;

@Service
public class TodoService {

  @Autowired
  private TodoRepository todoRepository;

  public Todo save(Todo todoItem) {
    return todoRepository.save(todoItem);
  }

  public Todo getById(int id) {
    return todoRepository.findById(id).orElseGet(null);
  }

  public void deleteTodoById(int id) {
    todoRepository.deleteById(id);
  }

  public Todo update(Todo todoItem) {
    Todo existing = todoRepository.findById(todoItem.getId()).orElse(null);
    if (existing == null) {
      return null;
    }

    existing.setName(todoItem.getName());
    existing.setDescription(todoItem.getDescription());
    existing.setStatus(todoItem.getStatus());
    return todoRepository.save(existing);
  }

  public List<Todo> getAll() {
    return todoRepository.findAll();
  }
}
