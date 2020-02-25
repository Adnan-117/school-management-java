package celum.exercise.springBoot.restController;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import celum.exercise.springBoot.model.Courses;
import celum.exercise.springBoot.repository.CourseRepository;

@RestController
public class CourseRestController {

	private CourseRepository courseRepository;

	public CourseRestController(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@GetMapping(value = "/courses")
	public Collection<Courses> getCourses() {
		return courseRepository.findAll().stream().collect(Collectors.toList());
	}
	
	@GetMapping(value = "/courseById/{id}")
	public Optional<Courses> getCoursesById(@PathVariable(value = "id") Long id) {
		return courseRepository.findById(id);
	}
	
	@RequestMapping(value = "/persistCourse", method = RequestMethod.POST)
	public void persistCourse(@RequestBody Courses courses) {
		courseRepository.save(courses);
	}
	
	@RequestMapping(value = "/updateCourse", method = RequestMethod.PUT)
	public void updateCourse(@RequestBody Courses courses) {
		courseRepository.save(courses);
	}
	
	@RequestMapping(value = "/deleteCourse/{id}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable(value = "id") Long id) {
		courseRepository.deleteById(id);
	}
	
}
