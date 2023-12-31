package School.Management.School.Management.Controllers;

import School.Management.School.Management.Models.Email;
import School.Management.School.Management.Services.emailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
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

    @Scheduled(cron = "0 */10 * * * *")
    public String sendMailWithAttachment(){
        Email email = new Email();
        email.setRecipient("nidhalsalim98@gmail.com");
        email.setSubject("School Report");
        email.setMsgBody("This is School Report and it autogenerated");
        email.setAttachment("C:/Users/user012/Desktop/Spring boot/SchoolReport.pdf");
        String status = emailService.sendMailWithAttachment(email);
        return status;
    }
}
