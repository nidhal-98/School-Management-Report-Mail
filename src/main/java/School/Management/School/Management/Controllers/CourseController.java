package School.Management.School.Management.Controllers;

import School.Management.School.Management.Models.Course;
import School.Management.School.Management.Models.Student;
import School.Management.School.Management.Models.StudentCourse;
import School.Management.School.Management.Services.CourseService;
import School.Management.School.Management.Services.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/school/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    StudentCourseService studentCourseService;

    @PostMapping("/{school_id}")
    public String newCourse(@PathVariable("school_id") Long schoolId, @RequestBody Course course){
        courseService.newCourse(schoolId, course);
        return "Course has been added";
    }

    @PostMapping("/{course_id}/student/{student_id}")
    public String newGrade(@PathVariable("course_id") Long courseId, @PathVariable("student_id") Long studentId, @RequestBody StudentCourse studentCourse){
        studentCourseService.newGrade(courseId, studentId, studentCourse);
        return "Grade has been added";
    }
}
