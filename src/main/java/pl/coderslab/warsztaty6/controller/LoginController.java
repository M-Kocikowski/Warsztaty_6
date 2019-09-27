package pl.coderslab.warsztaty6.controller;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.warsztaty6.entity.User;
import pl.coderslab.warsztaty6.repository.UserRepo;
import pl.coderslab.warsztaty6.validation.LoginValidationGroup;

@Controller
@SessionAttributes("user")
public class LoginController {

    private UserRepo userRepo;

    public LoginController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@Validated(LoginValidationGroup.class) User user, BindingResult result, Model model){
        if (result.hasErrors() || !isAuthorized(user)){
            return "login";
        }
        User user1 = userRepo.findFirstByEmail(user.getEmail());
        model.addAttribute("user", user1);
        return "redirect:/";
    }

    private boolean isAuthorized(User user) {
        User firstByEmail = userRepo.findFirstByEmail(user.getEmail());
        if (firstByEmail == null){
            return false;
        }
        return BCrypt.checkpw(user.getPassword(), firstByEmail.getPassword());
    }

}
