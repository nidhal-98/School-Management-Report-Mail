package School.Management.School.Management.Controllers;

import School.Management.School.Management.Services.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    ReportService report;

    @GetMapping("/schools")
    public ResponseEntity<String> generateSchoolReport() {
        try {
            String reportPath = report.generateReport();
            return ResponseEntity.ok(reportPath);
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error generating report.");
        }
    }

    @GetMapping("/courses")
    public ResponseEntity<String> generateCoursesReport() {
        try {
            String reportPath = report.generateCourseReport();
            return ResponseEntity.ok(reportPath);
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error generating report.");
        }
    }
}
