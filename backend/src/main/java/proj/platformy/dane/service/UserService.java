package proj.platformy.dane.service;

import javax.persistence.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.platformy.dane.entity.User;
import proj.platformy.dane.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public User getUser(User user) {
    return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
  }

  public boolean getUserByUsername(String username, String password) {
    boolean usernamePresent;
    boolean passwordPresent;
    try {
      usernamePresent = userRepository.findTopByUsername(username) != null;
      passwordPresent = userRepository.findTopByPassword(password) != null;
    } catch (NonUniqueResultException nre) {
      return true;
    }
    return usernamePresent && passwordPresent;
  }

  public boolean findUserByUsername(String username) {
    boolean usernamePresent;
    try {
      usernamePresent = userRepository.findTopByUsername(username) != null;
    } catch (NonUniqueResultException nre) {
      return true;
    }
    return usernamePresent;
  }

  public void saveUser(User user) {
    userRepository.save(user);
  }
}
