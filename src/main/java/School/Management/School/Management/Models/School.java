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
@Table(name = "schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "school")
    @JsonIgnore
    List<Student> studentList;

    @OneToMany(mappedBy = "school")
    @JsonIgnore
    List<Course> courseList;
}
