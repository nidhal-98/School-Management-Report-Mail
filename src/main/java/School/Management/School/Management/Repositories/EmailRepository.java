package School.Management.School.Management.Repositories;

import School.Management.School.Management.Models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository {
    String sendEmail(Email email);
    String sendMailWithAttachment(Email details);
}
