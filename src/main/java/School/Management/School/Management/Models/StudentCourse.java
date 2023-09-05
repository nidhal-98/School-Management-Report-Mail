package School.Management.School.Management.Models;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "studentwithcourses")
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    Float grade;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;
}
