package ph.edu.dlsu.securde.SECURDE_MP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import ph.edu.dlsu.securde.SECURDE_MP.model.User;
import ph.edu.dlsu.securde.SECURDE_MP.repository.UserRepository;

import java.util.Random;

@Controller
public class ForgotPasswordService {

    @Autowired
    private UserRepository userRepository;

    private static final ForgotPasswordService instance = new ForgotPasswordService();

    private ForgotPasswordService() {}

    public static ForgotPasswordService getInstance() {
        return instance;
    }

    public boolean forgotPassword(User user) {
        Random rand = new Random();
        String resetPassword = "";
        for (int i = 0 ; i < 10 ; i++) {
            String character = "";
            character += (char) (97 + rand.nextInt(26));
            if (rand.nextBoolean())
                character = character.toUpperCase();
            resetPassword += character;
        }
        String subject = "You Forgot Your Password!";
        String msg = "We have reset your password. Here it is: " + resetPassword;
        String emailTo = user.getEmail();
        EmailService emailService = EmailService.getInstance();
        if (emailService.sendEmail(emailTo, subject, msg)) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(resetPassword));
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
