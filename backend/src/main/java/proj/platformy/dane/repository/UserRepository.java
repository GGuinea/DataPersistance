package proj.platformy.dane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proj.platformy.dane.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  User findByUsernameAndPassword(String username, String password);

  User findTopByUsername(String username);

  User findTopByPassword(String password);
}
