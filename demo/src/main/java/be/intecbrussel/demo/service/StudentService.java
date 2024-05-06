package be.intecbrussel.demo.service;

import be.intecbrussel.demo.model.Student;
import be.intecbrussel.demo.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final IStudentRepository isr;

    @Autowired
    public StudentService (IStudentRepository isr){
        this.isr = isr;
    }

    public List<Student> getStudents(){
        return isr.findAll();
    }

    public void addNewStudent(Student student){
        Optional<Student> studentOptional = isr.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("mail taken");
        }
        isr.save(student);
    }

    public void deleteStudent(Long studentId){
        boolean studentPresent = isr.existsById(studentId);
        if (!studentPresent){
            throw new IllegalStateException("Student n°" + studentId + " does not exist");
        }
        isr.deleteById(studentId);
    }

    public void updateStudent(Student newStudent, Long idStudent){

    }

}
