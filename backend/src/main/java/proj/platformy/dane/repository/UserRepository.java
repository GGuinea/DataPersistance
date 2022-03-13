package proj.platformy.dane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.platformy.dane.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

  User findByUsernameAndPassword(String username, String password);

  User findTopByUsername(String username);

  User findTopByPassword(String password);
}
