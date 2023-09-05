package School.Management.School.Management.Services;

import School.Management.School.Management.Models.Course;
import School.Management.School.Management.Models.School;
import School.Management.School.Management.Models.Student;
import School.Management.School.Management.Models.StudentCourse;
import School.Management.School.Management.Repositories.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {

    @Autowired
    StudentCourseRepository studentCourseRepository;

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @Autowired
    SchoolService schoolService;

    public String newGrade(Long courseId, Long studentId, StudentCourse studentCourse){
        Course course = courseService.getCourseById(courseId);
        Student student = studentService.getStudentById(studentId);


        studentCourse.setCourse(course);
        studentCourse.setStudent(student);

        studentCourseRepository.save(studentCourse);

        return "Grade has been added";
    }
}
