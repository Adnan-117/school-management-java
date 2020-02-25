package celum.exercise.springBoot;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import celum.exercise.springBoot.model.Courses;
import celum.exercise.springBoot.model.Students;
import celum.exercise.springBoot.repository.CourseRepository;
import celum.exercise.springBoot.repository.StudentRepository;

@SpringBootApplication
//@ComponentScan("celum.exercise.springBoot")
public class SchoolManagementApplication implements CommandLineRunner{
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementApplication.class, args);
	}
	
/*    @Bean
    ApplicationRunner init(StudentRepository repository) {
        return args -> {
            Stream.of(new Students("Adnan", "Adnan", "adnan_khaliq37@yahoo.com", "00393802876821")
            		,new Students("Adnan", "Adnan", "adnan_khaliq37@yahoo.com", "00393802876821")).forEach(student -> {
            	Courses course = new Courses("Maths",new Date());
            	student.getCourses().add(course);
                repository.save(student);
            });
            repository.findAll().forEach(System.out::println);
        };
    }*/
	

    @Override
    public void run(String... args) throws Exception {
/*    	studentRepository.deleteAllInBatch();
    	courseRepository.deleteAllInBatch();*/
    	
    	//// Persist course containing Students////
    	
    	/*Students student1 = new Students("Adnan", "Adnan", "adnan_khaliq37@yahoo.com", "00393802876821");
    	
    	Set<Students> setStudents = new HashSet<>();
    	setStudents.add(student1);
    	
    	Courses courseMath = new Courses("Maths", new Date(), setStudents);
    	
    	courseRepository.save(courseMath);*/
    	
    	
    	///// Persist Students to a course//////
    	
    	/*Courses courseTelecom = new Courses("Telecom", new Date());
    	
    	Students student1 = new Students("Adnan", "Adnan", "adnan_khaliq37@yahoo.com", "00393802876821");
    	Students student2 = new Students("Adnan", "Adnan", "adnan_khaliq37@yahoo.com", "00393802876821");
    	
    	student1.getCourses().add(courseTelecom);
    	student2.getCourses().add(courseTelecom);
    	
    	courseTelecom.getStudents().add(student1);
    	courseTelecom.getStudents().add(student2);
    	
    	Set<Students> setStudents = new HashSet<>();
    	setStudents.add(student1);
    	setStudents.add(student2);
    	
    	studentRepository.saveAll(setStudents); */
    	
    	///// Delete Course by Id //////
    	/*courseRepository.deleteById((long) 26);*/
    	
    	//// Delete a student from a course /////
//    	studentRepository.deleteById((long)43);
    	   	
    }

}
