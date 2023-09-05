package School.Management.School.Management.ReportObject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseReport {

    String courseName;
    String courseCode;
    Float marks;
}
