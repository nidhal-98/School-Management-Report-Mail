package School.Management.School.Management.Services;

import School.Management.School.Management.Models.School;
import School.Management.School.Management.Models.Student;
import School.Management.School.Management.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SchoolService schoolService;

    public Student newStudent(Long id, Student student){
        School school = schoolService.getSchoolById(id);
        student.setSchool(school);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudent(Long schoolId){
        return studentRepository.findBySchoolId(schoolId);
    }

    public Student getStudentById(Long studentId){
        return studentRepository.findById(studentId).get();
    }
}
