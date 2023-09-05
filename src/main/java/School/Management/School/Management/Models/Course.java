package School.Management.School.Management.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String courseCode;

    @OneToMany(mappedBy = "course")
    List<StudentCourse> studentCourseList;

    @ManyToOne
    @JoinColumn(name = "school_id")
    School school;
}
