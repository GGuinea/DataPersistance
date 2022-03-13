package proj.platformy.dane.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import proj.platformy.dane.entity.User;
import proj.platformy.dane.service.UserService;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/test")
  private String connectionTest() {
    return "Working";
  }

  @GetMapping("/login")
  private User getCurrentUser(@RequestBody User user) {
    return userService.getUser(user);
  }

  @GetMapping("/login/{username}/{password}")
  private boolean findUserByUsername(@PathVariable String username, @PathVariable String password) {
    return userService.getUserByUsername(username, password);
  }

  @PostMapping("/createUser")
  private boolean addUser(@RequestBody User user) {
    boolean userExist = userService.findUserByUsername(user.getUsername());
    if (userExist) {
      return false;
    }
    userService.saveUser(user);
    return true;
  }
}
