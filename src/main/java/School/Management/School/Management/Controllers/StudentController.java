package School.Management.School.Management.Controllers;

import School.Management.School.Management.Models.Student;
import School.Management.School.Management.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/{school_id}")
    public String newStudent(@PathVariable("school_id") Long schoolId, @RequestBody Student student){
        studentService.newStudent(schoolId, student);
        return "Student has been added";
    }

    @GetMapping("/{school_id}")
    public List<Student> getAllStudents(@PathVariable("school_id") Long schoolId){
        return studentService.getAllStudent(schoolId);
    }
}
