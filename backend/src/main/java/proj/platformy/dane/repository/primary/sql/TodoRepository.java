package proj.platformy.dane.repository.primary.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proj.platformy.dane.entity.sql.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
