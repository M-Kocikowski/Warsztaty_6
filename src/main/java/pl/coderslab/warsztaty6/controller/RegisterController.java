package pl.coderslab.warsztaty6.controller;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.warsztaty6.entity.User;
import pl.coderslab.warsztaty6.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
@SessionAttributes("appUser")
public class RegisterController {

    private UserRepository userRepository;

    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String getRegister(Model model){
        model.addAttribute("appUser", new User());
        return "register";
    }

    @PostMapping
    public String postMapping(@ModelAttribute("appUser") @Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            return "register";
        }
        else{
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            userRepository.save(user);
            model.addAttribute("appUser", user);
            return "redirect:/";
        }
    }
}
