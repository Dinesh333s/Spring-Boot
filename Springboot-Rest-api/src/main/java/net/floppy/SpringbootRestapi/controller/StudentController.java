package net.floppy.SpringbootRestapi.controller;

import net.floppy.SpringbootRestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("student")
    public Student get_student() {
        Student student = new Student(
                1,
                "Dinesh",
                "s"
        );
        return student;
    }

    //http://localhost:8080/students
    @GetMapping("students")
    public List<Student> get_students() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Raj", "kumar"));
        students.add(new Student(2, "Roman", "powel"));
        students.add(new Student(3, "Joe", "Weller"));
        students.add(new Student(4, "Mr", "Whoisthebose"));
        return students;
    }

    //http://localhost:8080/student/1/dinesh/s
    //{id} - URI template
    @GetMapping("student/{id}/{first-name}/{last-name}")
    public Student pathvariable(@PathVariable("id") int studentid,
                                @PathVariable("first-name") String fistName,
                                @PathVariable("last-name") String lastName) {
        return new Student(studentid, fistName, lastName);
    }

    //http://localhost:8080/students/query?id=1&firstName=Dinesh&lastName=s
    //RequestParam extract the value of queryparameter in a request url
   @GetMapping("student/query")
    public Student requestparam(@RequestParam int id,
                                @RequestParam  String firstName,
                                @RequestParam String lastName)
    {
        return new Student(id,firstName,lastName);
    }

    //http://localhost:8080/student/create
    //RequestBody - retrieve HTTP request body JSON and convert to java object
    @PostMapping("student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student student)
    {
        System.out.println(student.getId());
        System.out.println(student.getFirst_name());
        System.out.println(student.getLast_name());
        return student;
    }
}
