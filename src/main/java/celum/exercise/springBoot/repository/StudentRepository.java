package celum.exercise.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import celum.exercise.springBoot.model.Students;


@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {

}
