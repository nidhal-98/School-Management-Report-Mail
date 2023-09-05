package School.Management.School.Management.Repositories;

import School.Management.School.Management.Models.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

}
