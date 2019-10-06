package pl.coderslab.warsztaty6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.warsztaty6.entity.Tweet;
import pl.coderslab.warsztaty6.entity.User;
import pl.coderslab.warsztaty6.repository.TweetRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MainController {

    private TweetRepository tweetRepository;

    @Autowired
    public MainController(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @GetMapping("/")
    public String getIndex(Model model){
        List<Tweet> allTweets = tweetRepository.findTweetsByOrderByCreatedDesc();
        model.addAttribute("allTweets", allTweets);
        model.addAttribute("newTweet", new Tweet());
        return "index";
    }

    @PostMapping("/")
    public String postIndex(@ModelAttribute("newTweet") @Valid Tweet tweet, BindingResult result, HttpSession session){
        if (result.hasErrors()){
            return "index";
        }
        tweet.setUser((User) session.getAttribute("appUser"));
        tweet.setCreated(LocalDateTime.now());
        tweetRepository.save(tweet);
        return "redirect:/";
    }
}
