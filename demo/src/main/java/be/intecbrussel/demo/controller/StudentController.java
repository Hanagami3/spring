package be.intecbrussel.demo.controller;

import be.intecbrussel.demo.model.Student;
import be.intecbrussel.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

   @Autowired
    private StudentService ss;

   @GetMapping
   //public String Hello(){
   //    return "Hello World";
   //}
    public List<Student> getStudents(){
       return ss.getStudents();
   }

   @PostMapping
    public void registerNewStudent(@RequestBody Student student){
       ss.addNewStudent(student);
   }

   @DeleteMapping(path = "{studentId}")
   public void deleteStudent(@PathVariable("studentId") Long studentId){

       ss.deleteStudent(studentId);
   }
}
