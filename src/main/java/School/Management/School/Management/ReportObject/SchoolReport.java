package School.Management.School.Management.ReportObject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SchoolReport {
    Long studentId;
    String studentName;
    String schoolName;
}
