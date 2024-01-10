package net.floppy.SpringbootRestapi.controller;

import net.floppy.SpringbootRestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    //http://localhost:8080/student
    @GetMapping
    public ResponseEntity<Student> get_student() {
        Student student = new Student(
                1,
                "Dinesh",
                "s"
        );
//        return new ResponseEntity<>(student, HttpStatus.OK);
//        return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("Custom-Header", "Dinesh").body(student);
    }

    //http://localhost:8080/students
    @GetMapping("students")
    public ResponseEntity<List<Student>> get_students() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Raj", "kumar"));
        students.add(new Student(2, "Roman", "powel"));
        students.add(new Student(3, "Joe", "Weller"));
        students.add(new Student(4, "Mr", "Whoisthebose"));
        return ResponseEntity.ok(students);
    }

    //http://localhost:8080/student/1/dinesh/s
    //{id} - URI template
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> pathvariable(@PathVariable("id") int studentid,
                                @PathVariable("first-name") String fistName,
                                @PathVariable("last-name") String lastName) {
        Student student = new Student(studentid, fistName, lastName);
        return ResponseEntity.ok(student);
    }

    //http://localhost:8080/students/query?id=1&firstName=Dinesh&lastName=s
    //RequestParam extract the value of queryparameter in a request url
   @GetMapping("query")
    public ResponseEntity<Student> requestparam(@RequestParam int id,
                                @RequestParam  String firstName,
                                @RequestParam String lastName)
    {
        Student student=  new Student(id,firstName,lastName);
        return ResponseEntity.ok(student);
    }

    //http://localhost:8080/student/create
    //RequestBody - retrieve HTTP request body JSON and convert to java object
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> create(@RequestBody Student student)
    {
        System.out.println(student.getId());
        System.out.println(student.getFirst_name());
        System.out.println(student.getLast_name());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
    @PutMapping("{id}/update")
    public ResponseEntity<Student> update(@RequestBody Student student,@PathVariable("id") int studentid)
    {
        System.out.println(student.getId());
        System.out.println(student.getFirst_name());
        System.out.println(student.getLast_name());
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int studentid)
    {
        System.out.println(studentid);
        return ResponseEntity.ok("Resource Deleted Successfully");
    }
}
