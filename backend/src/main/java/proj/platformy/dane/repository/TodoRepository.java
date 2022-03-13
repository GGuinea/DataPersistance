package proj.platformy.dane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proj.platformy.dane.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
