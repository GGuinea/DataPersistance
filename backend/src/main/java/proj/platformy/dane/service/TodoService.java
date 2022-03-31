package proj.platformy.dane.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import proj.platformy.dane.entity.noSql.TodoNoSql;
import proj.platformy.dane.entity.sql.Todo;
import proj.platformy.dane.repository.primary.noSql.CassandraTodoRepository;
import proj.platformy.dane.repository.primary.sql.TodoRepository;
import proj.platformy.dane.repository.secondary.AnalitycsTodoRepository;

@Service
@EnableTransactionManagement
public class TodoService {

  @Autowired
  private TodoRepository todoRepository;

  @Autowired
  private AnalitycsTodoRepository analitycsTodoRepository;

  @Autowired
  private CassandraTodoRepository cassandraTodoRepository;

  public Todo save(Todo todoItem) {
    analitycsTodoRepository.save(new Todo(todoItem));
    cassandraTodoRepository.save(TodoNoSql.builder().id(UUID.randomUUID()).name(todoItem.getName()).description(todoItem.getDescription()).status(todoItem.getStatus()).build());
    return todoRepository.save(new Todo(todoItem));
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
