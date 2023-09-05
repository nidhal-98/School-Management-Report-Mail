package School.Management.School.Management.Controllers;

import School.Management.School.Management.Models.School;
import School.Management.School.Management.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/school")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @PostMapping
    public String newSchool(@RequestBody School school){
        schoolService.newSchool(school);
        return "School has been added";
    }

    @GetMapping
    public List<School> getAllSchool(){
        return schoolService.getAllSchool();
    }

    @GetMapping("/{school_id}")
    public School getSchool(@PathVariable("school_id") Long schoolId){
        return schoolService.getSchoolById(schoolId);
    }
}
