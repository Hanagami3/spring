package be.intecbrussel.demo.repository;



import be.intecbrussel.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    //Om SQL te definiëren die moet worden uitgevoerd voor een Spring Data-repositoryMethode
    @Query("SELECT s FROM Student s WHERE s.email=?1")
    Optional<Student> findStudentByEmail(String email);
}
