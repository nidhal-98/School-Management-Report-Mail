package School.Management.School.Management.Services;

import School.Management.School.Management.Models.Course;
import School.Management.School.Management.Models.School;
import School.Management.School.Management.Models.Student;
import School.Management.School.Management.Models.StudentCourse;
import School.Management.School.Management.ReportObject.CourseReport;
import School.Management.School.Management.ReportObject.SchoolReport;
import School.Management.School.Management.Repositories.CourseRepository;
import School.Management.School.Management.Repositories.SchoolRepository;
import School.Management.School.Management.Repositories.StudentCourseRepository;
import School.Management.School.Management.Repositories.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    String pathToReports = "C:\\Users\\user012\\Desktop\\Spring boot";

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    StudentCourseRepository studentCourseRepository;

    public String generateReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.findAll();
        List<Student> studentList = studentRepository.findAll();

        List<SchoolReport> schoolsReportList = new ArrayList<>(); // New list to hold reports

        for (School s : schoolList) {
            for (Student student : studentList) {
                if (student.getSchool().getId().equals(s.getId())) {
                    SchoolReport schoolsReport = SchoolReport.builder()
                            .schoolName(s.getName())
                            .studentName(student.getName())
                            .studentId(student.getId())
                            .build();
                    schoolsReportList.add(schoolsReport); // Add report to the list
                }
            }
        }
        File file = ResourceUtils.getFile("classpath:school.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

// Create a data source from the reports list
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolsReportList);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Nidhal");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\SchoolReport.pdf");
        return "Report generated: " + pathToReports + "\\SchoolReport.pdf";
    }

    public String generateCourseReport() throws FileNotFoundException, JRException {
        List<StudentCourse> studentCourseList = studentCourseRepository.findAll();
        List<Course> courseList = courseRepository.findAll();

        List<CourseReport> courseReportList = new ArrayList<>();

        for (StudentCourse s : studentCourseList){
            for(Course c : courseList){
                if(s.getCourse().getId().equals(c.getId())){
                    CourseReport courseReport = CourseReport.builder()
                            .courseName(s.getCourse().getCourseName())
                            .courseCode(s.getCourse().getCourseCode())
                            .marks(s.getGrade())
                            .build();
                            courseReportList.add(courseReport);
                }
            }
        }

        File file = ResourceUtils.getFile("classpath:courses.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // Create a data source from the reports list
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(courseReportList);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "Nidhal");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\CourseReport.pdf");
        return "Report generated: " + pathToReports + "\\CourseReport.pdf";
    }


}