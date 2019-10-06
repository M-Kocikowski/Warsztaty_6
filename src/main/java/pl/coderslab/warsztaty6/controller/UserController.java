package pl.coderslab.warsztaty6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.warsztaty6.entity.User;
import pl.coderslab.warsztaty6.repository.TweetRepository;
import pl.coderslab.warsztaty6.repository.UserRepository;

@Controller
@RequestMapping("/app/user")
public class UserController {

    private UserRepository userRepository;

    private TweetRepository tweetRepository;

    @Autowired
    public UserController(UserRepository userRepository, TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long id, Model model){
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("userTweets", tweetRepository.findTweetsByUserIdOrderByCreatedDesc(user));
        return "user";
    }
}
