package School.Management.School.Management.Repositories;

import School.Management.School.Management.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findBySchoolId(Long schoolID);
}
