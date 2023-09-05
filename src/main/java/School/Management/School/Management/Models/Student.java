package School.Management.School.Management.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "school_id")
    School school;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    List<StudentCourse> studentCourseList;
}
