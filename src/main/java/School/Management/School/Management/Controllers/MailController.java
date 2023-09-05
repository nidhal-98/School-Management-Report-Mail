package School.Management.School.Management.Controllers;

import School.Management.School.Management.Models.Email;
import School.Management.School.Management.Services.emailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/school")
public class MailController {

    @Autowired
    emailService emailService;

    @PostMapping("/msg")
    public String sendMail(@RequestBody Email email){
        String status = emailService.sendEmail(email);
        return status;
    }

    @PostMapping("/attachement")
    public String sendMailWithAttachment(@RequestBody Email email){
        String status = emailService.sendMailWithAttachment(email);
        return status;
    }
}
