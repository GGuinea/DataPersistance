package proj.platformy.dane.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import proj.platformy.dane.entity.Course;
import proj.platformy.dane.service.CourseService;

@Slf4j
@RestController
@CrossOrigin(origins = { "http://localhost:3000"})
public class CourseController {

  @Autowired
  private CourseService courseService;

  @PostMapping("/addCourse")
  public Course addCourse(@RequestBody Course course) {
    log.info("Course object {}", course.toString());
    return courseService.saveCourse(course);
  }

  @PostMapping("/addCourses")
  public List<Course> addCourses(@RequestBody List<Course> courses) {
    return courseService.saveCourses(courses);
  }

  @GetMapping("/courses")
  public List<Course> getAllCourses() {
    return courseService.getCourses();
  }

  @GetMapping("/courseById/{id}")
  public Course findCourseById(@PathVariable int id) {
    return courseService.getCourseById(id);
  }

  @GetMapping("/courseByName/{name}")
  public Course findCourseByName(@PathVariable String name) {
    return courseService.getCourseByName(name);
  }

  @GetMapping("/listCourseByUsername/{username}")
  public List<Course> findCoursesByUsername(@PathVariable String username) {
    return courseService.getCoursesForUser(username);
  }

  @PutMapping("/update")
  public Course updateCourse(@RequestBody Course course) {
    return courseService.updateCourse(course);
  }

  @DeleteMapping("/delete/{id}")
  public String deleteCourse(@PathVariable int id) {
    return courseService.deleteCourse(id);
  }
}
