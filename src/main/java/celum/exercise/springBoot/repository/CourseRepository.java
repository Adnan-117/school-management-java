package celum.exercise.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import celum.exercise.springBoot.model.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long> {

}
