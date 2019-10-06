package pl.coderslab.warsztaty6.controller;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import pl.coderslab.warsztaty6.entity.User;
import pl.coderslab.warsztaty6.repository.UserRepository;
import pl.coderslab.warsztaty6.validation.LoginValidationGroup;

@Controller
@SessionAttributes("appUser")
public class LoginController {

    private UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("appUser", new User());
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@Validated(LoginValidationGroup.class) User user, BindingResult result, Model model){
        if (result.hasErrors() || !isAuthorized(user)){
            return "login";
        }
        User user1 = userRepository.findFirstByEmail(user.getEmail());
        model.addAttribute("appUser", user1);
        return "redirect:/";
    }

    @GetMapping("/app/logout")
    public String getLogout(SessionStatus status){
        status.setComplete();
        return "redirect:/";
    }

    private boolean isAuthorized(User user) {
        User firstByEmail = userRepository.findFirstByEmail(user.getEmail());
        if (firstByEmail == null){
            return false;
        }
        return BCrypt.checkpw(user.getPassword(), firstByEmail.getPassword());
    }

}
