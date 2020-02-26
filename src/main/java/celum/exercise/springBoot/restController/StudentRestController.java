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

import celum.exercise.springBoot.model.Students;
import celum.exercise.springBoot.repository.StudentRepository;

@RestController
public class StudentRestController {

	private StudentRepository studentRepository;

	public StudentRestController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@GetMapping("/students")
	public Collection<Students> getSudents() {
		return studentRepository.findAll().stream().collect(Collectors.toList());
	}
	
	@GetMapping(value = "/students/{id}")
	public Optional<Students> getStudentsById(@PathVariable(value = "id") Long id) {
		return studentRepository.findById(id);
	}
	
	@RequestMapping(value = "/updateStudents", method = RequestMethod.PUT)
	public void updateStudentFromCourse(@RequestBody Students student) {
		studentRepository.save(student);
	}
	
	@RequestMapping(value = "/deleteStudents/{id}", method = RequestMethod.DELETE)
	public void deleteStudentFromCourse(@PathVariable(value = "id") Long id) {
		studentRepository.deleteById(id);
	}

}
