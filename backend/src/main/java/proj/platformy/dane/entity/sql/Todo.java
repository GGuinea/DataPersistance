package proj.platformy.dane.entity.sql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;
  private String description;
  private String status;

  public Todo(Todo todoItem) {
    this.id = todoItem.getId();
    this.name = todoItem.getName();
    this.description = todoItem.getDescription();
    this.status = todoItem.getStatus();
  }

  public Todo(int id, String description) {
    this.id = id;
    this.description = description;
  }
}
