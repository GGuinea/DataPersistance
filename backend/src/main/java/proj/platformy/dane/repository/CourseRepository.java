package proj.platformy.dane.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proj.platformy.dane.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

  Course findByName(String name);

  List<Course> findAllByUsername(String username);
}
