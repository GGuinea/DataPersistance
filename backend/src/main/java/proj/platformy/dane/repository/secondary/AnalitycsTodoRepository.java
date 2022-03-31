package proj.platformy.dane.repository.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proj.platformy.dane.entity.sql.Todo;

@Repository
public interface AnalitycsTodoRepository extends JpaRepository<Todo, Long> {

}
