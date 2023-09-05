package School.Management.School.Management.Services;

import School.Management.School.Management.Models.Course;
import School.Management.School.Management.Models.School;
import School.Management.School.Management.Models.Student;
import School.Management.School.Management.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SchoolService schoolService;

    public Course newCourse(Long id, Course course){
        School school = schoolService.getSchoolById(id);
        course.setSchool(school);
        return courseRepository.save(course);
    }

    public Course getCourseById(Long courseId){
        return courseRepository.findById(courseId).get();
    }

//    public Course getCourseBySchool(Long schoolId, Long courseId){
//        return courseRepository.findCourseBySchoolId(schoolId, courseId);
//    }
}
