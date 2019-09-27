package pl.coderslab.warsztaty6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.warsztaty6.entity.User;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user == null){
            return "redirect:/login";
        }
        return "index";
    }
}
