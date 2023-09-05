package School.Management.School.Management.Services;

import School.Management.School.Management.Models.School;
import School.Management.School.Management.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    public School newSchool(School school){
        return schoolRepository.save(school);
    }

    public List<School> getAllSchool(){
        return schoolRepository.findAll();
    }

    public School getSchoolById(Long id){
        return schoolRepository.findById(id).get();
    }

}
