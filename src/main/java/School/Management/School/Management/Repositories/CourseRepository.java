package School.Management.School.Management.Repositories;

import School.Management.School.Management.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    //Course findCourseBySchoolId(Long schoolID, Long courseId);
}
