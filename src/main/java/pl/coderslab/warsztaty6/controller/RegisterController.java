package pl.coderslab.warsztaty6.controller;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.warsztaty6.entity.User;
import pl.coderslab.warsztaty6.repository.UserRepo;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
@SessionAttributes("user")
public class RegisterController {

    private UserRepo userRepo;

    public RegisterController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String getRegister(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String postMapping(@ModelAttribute("user") @Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            return "register";
        }
        else{
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            userRepo.save(user);
            model.addAttribute("user", user);
            return "redirect:/";
        }
    }
}
